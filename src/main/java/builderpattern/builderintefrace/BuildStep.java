package builderpattern.builderintefrace;

import builderpattern.product.Menu;

public interface BuildStep {
    Menu build();
}
