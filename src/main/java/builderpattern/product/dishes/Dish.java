package builderpattern.product.dishes;

import builderpattern.enums.Diet;

import java.util.HashSet;
import java.util.Set;

public class Dish {
    private String name;
    private Set<Diet> dietFlag;

    public Dish(String name) {
        this.name = name;
        dietFlag = new HashSet<>();
    }

    public void setVegan() {
        dietFlag.add(Diet.VEGAN);
   }

    public void setGlutenFree() {
        dietFlag.add(Diet.GLUTEN_FREE);
    }

    public String getName() {
        return name;
    }

    public Set<Diet> getDietFlag() {
        return dietFlag;
    }
}
