package builderpattern.builderintefrace;

import builderpattern.product.Menu;

public interface ICanAddDrink {
    IAfterDrink withDrink(String drink);
    Menu build();
}
