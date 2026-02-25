package observerpattern;

import java.util.ArrayList;
import java.util.List;

public class StockAgent implements Observable<Observer<StockEvent>> {
    private Stock stock;
    private final List<Observer<StockEvent>> observers = new ArrayList<>();

    public StockAgent(Stock stock) {
        this.stock = stock;
    }

    public List<Observer<StockEvent>> getObservers() {
        return List.copyOf(observers);
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
    public void attach(Observer<StockEvent> observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer<StockEvent> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer<StockEvent> observer : observers) {
            observer.update(new StockEvent(stock));
        }
    }
}
