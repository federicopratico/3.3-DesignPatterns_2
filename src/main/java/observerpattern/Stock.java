package observerpattern;

public class Stock {
    private final String name;
    private double oldValue;
    private double actualValue;

    public Stock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getOldValue() {
        return oldValue;
    }

    public double getActualValue() {
        return actualValue;
    }

    public void setValue(double newValue) {
        oldValue = actualValue;
        actualValue = newValue;
    }
}
