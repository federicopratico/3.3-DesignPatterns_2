package builderpattern.concretebuilder;

import builderpattern.builderintefrace.*;
import builderpattern.product.Menu;
import builderpattern.product.dishes.Coffee;
import builderpattern.product.dishes.Dish;
import builderpattern.product.dishes.Drink;
import builderpattern.product.dishes.MainCourse;

public class MenuBuilder implements IStart, IAfterStarter, IAfterMainCourse, ICanAddDrink, IAfterDrink, ICanAddMainCourse {
    private Dish starter;
    private MainCourse mainCourse;
    private Dish dessert;
    private Coffee coffee;
    private Drink drink;

    private void resetBuilder() {
        this.starter = null;
        this.mainCourse = null;
        this.dessert = null;
        this.coffee = null;
        this.drink = null;
    }

    @Override
    public IAfterStarter withStarter(String starter) {
        this.starter = new Dish(starter);
        return this;
    }

    @Override
    public IAfterMainCourse withMainCourse(String mainCourse) {
        this.mainCourse = new MainCourse(mainCourse);
        return this;
    }

    @Override
    public IAfterMainCourse withSupplement(String supplement) {
        mainCourse.addSupplement(supplement);
        return this;
    }

    @Override
    public ICanAddDrink withCoffee(String coffee) {
        this.coffee = new Coffee(coffee);
        return this;
    }

    @Override
    public ICanAddDrink withDessert(String dessert) {
        this.dessert = new Dish(dessert);
        return this;
    }

    @Override
    public IAfterDrink withDrink(String drink) {
        this.drink = new Drink(drink);
        return this;
    }

    @Override
    public Menu build() {
        Menu menu = new Menu(starter, mainCourse, dessert, coffee, drink);
        resetBuilder();
        return menu;
    }
}
