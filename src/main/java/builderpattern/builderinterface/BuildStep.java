package builderpattern.builderinterface;

import builderpattern.product.Menu;

public interface BuildStep {
    Menu build();
}
