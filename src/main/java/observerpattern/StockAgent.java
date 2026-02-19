package observerpattern;

import java.util.ArrayList;
import java.util.List;

public class StockAgent implements Observable<StockExchangeAgency> {
    private Stock stock;
    private final List<StockExchangeAgency> observers = new ArrayList<>();

    public StockAgent(Stock stock) {
        this.stock = stock;
    }

    public void stockGoesUp(double amount) {
        double newValue = stock.getActualValue() + amount;
        stock.setValue(newValue);
        notifyObservers();
    }

    public void stockGoesDown(double amount) {
        double newValue = stock.getActualValue() - amount;
        stock.setValue(newValue);
        notifyObservers();
    }

    @Override
    public void attach(StockExchangeAgency observer) {
        observers.add(observer);
    }

    @Override
    public void detach(StockExchangeAgency observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(StockExchangeAgency observer : observers) {
            observer.update(new StockEvent(stock));
        }
    }
}
