package observerpattern;

public class StockEvent {
    private final Stock stock;

    public StockEvent(Stock stock) {
        this.stock = stock;
    }

    public String getStockName() {
        return stock.getName();
    }

    public double getLastChangeValue() {
        return stock.getActualValue() - stock.getOldValue();
    }

    public boolean decrease() {
        return getLastChangeValue() < 0;
    }

    public boolean increase() {
        return getLastChangeValue() > 0;
    }
}
