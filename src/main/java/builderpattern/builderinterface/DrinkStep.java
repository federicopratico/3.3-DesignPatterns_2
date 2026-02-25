package builderpattern.builderinterface;

public interface DrinkStep {
    BuildStep withDrink(String drink);
}
