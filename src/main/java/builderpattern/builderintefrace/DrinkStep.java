package builderpattern.builderintefrace;

import builderpattern.product.Menu;

public interface DrinkStep {
    BuildStep withDrink(String drink);
}
