package observerpattern;

public class StockExchangeAgency implements Observer<StockEvent> {
    private String message;

    @Override
    public void update(StockEvent stockEvent) {
        if(stockEvent.decrease()) message = "Stock " + stockEvent.getStockName() + "is decreasing";
        if(stockEvent.increase()) message = "Stock " + stockEvent.getStockName() + "is increasing";

        showMessage();
    }

    public String getMessage() {
        return message;
    }

    public void showMessage() {
        System.out.println(message);
    }

}
