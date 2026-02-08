package builderpattern.product;

import builderpattern.product.dishes.Coffee;
import builderpattern.product.dishes.Dish;
import builderpattern.product.dishes.Drink;
import builderpattern.product.dishes.MainCourse;

public class Menu {
    private Dish starter;
    private MainCourse mainCourse;
    private Dish dessert;
    private Coffee coffee;
    private Drink drink;

    public Menu(Dish starter, MainCourse mainCourse, Dish dessert, Coffee coffee, Drink drink) {
        this.starter = starter;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
        this.coffee = coffee;
        this.drink = drink;
    }

    public Dish getStarter() {
        return starter;
    }

    public MainCourse getMainCourse() {
        return mainCourse;
    }

    public Dish getDessert() {
        return dessert;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public Drink getDrink() {
        return drink;
    }
}
