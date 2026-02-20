package observerpattern;

import java.util.Objects;

public class StockExchangeAgency implements Observer<StockEvent> {
    private final String name;
    private String message;

    public StockExchangeAgency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void update(StockEvent stockEvent) {
        if(stockEvent.decrease()) message = "Stock " + stockEvent.getStockName() + "is decreasing";
        if(stockEvent.increase()) message = "Stock " + stockEvent.getStockName() + "is increasing";

        showMessage();
    }

    public void showMessage() {
        System.out.println(message);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockExchangeAgency that = (StockExchangeAgency) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),getMessage());
    }
}
