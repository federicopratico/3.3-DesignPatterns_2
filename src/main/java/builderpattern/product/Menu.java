package builderpattern.product;

import builderpattern.builderinterface.*;
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

    private Menu(MenuBuilder builder) {
        this.starter = builder.starter;
        this.mainCourse = builder.mainCourse;
        this.dessert = builder.dessert;
        this.coffee = builder.coffee;
        this.drink = builder.drink;
    }

    public static StarterStep builder() {
        return MenuBuilder.newBuilder();
    }

    private static class MenuBuilder implements StarterStep {
        private Dish starter;
        private MainCourse mainCourse;
        private Dish dessert;
        private Coffee coffee;
        private Drink drink;

        private MenuBuilder() {}

        private static StarterStep newBuilder() {
            return new MenuBuilder();
        }

        @Override
        public AfterStarterStep withStarter(String starter) {
            this.starter = new Dish(starter);
            return new AfterStarterStepImpl(this);
        }

        @Override
        public AfterMainCourseStep withMainCourse(String mainCourse) {
            this.mainCourse = new MainCourse(mainCourse);
            return new AfterMainCourseStepImlp(this);
        }

        private class AfterStarterStepImpl implements AfterStarterStep {
            private MenuBuilder builder;

            private AfterStarterStepImpl(MenuBuilder menuBuilder) {
                this.builder = menuBuilder;
            }

            @Override
            public AfterStarterStep isVegan() {
                this.builder.starter.setVegan();
                return this;
            }

            @Override
            public AfterStarterStep isGlutenFree() {
                this.builder.starter.setGlutenFree();
                return this;
            }

            @Override
            public AfterMainCourseStep withMainCourse(String mainCourse) {
                this.builder.mainCourse = new MainCourse(mainCourse);
                return new AfterMainCourseStepImlp(this.builder);
            }
        }

        private class AfterMainCourseStepImlp implements AfterMainCourseStep {
            private MenuBuilder builder;

            private AfterMainCourseStepImlp(MenuBuilder builder) {
                this.builder = builder;
            }

            @Override
            public AfterMainCourseStep isVegan() {
                this.builder.mainCourse.setVegan();
                return this;
            }

            @Override
            public AfterMainCourseStep isGlutenFree() {
                this.builder.mainCourse.setGlutenFree();
                return this;
            }

            @Override
            public AfterMainCourseStep withSupplement(String supplement) {
                this.builder.mainCourse.addSupplement(supplement);
                return this;
            }

            @Override
            public DrinkStep withDessert(String dessert) {
                this.builder.dessert = new Dish(dessert);
                return new DrinkStepImpl(this.builder);
            }

            @Override
            public DrinkStep withCoffee(String coffee) {
                this.builder.coffee = new Coffee(coffee);
                return new DrinkStepImpl(this.builder);
            }
        }

        private class DrinkStepImpl implements DrinkStep {
            private MenuBuilder builder;

            private DrinkStepImpl(MenuBuilder builder) {
                this.builder = builder;
            }

            @Override
            public BuildStep withDrink(String drink) {
                this.builder.drink = new Drink(drink);
                return new BuildStepImpl(this.builder);
            }

        }

        private class BuildStepImpl implements BuildStep {
            private MenuBuilder builder;

            private BuildStepImpl(MenuBuilder builder) {
                this.builder = builder;
            }

            @Override
            public Menu build() {
                return new Menu(builder);
            }
        }
    }

    // Getters
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

    @Override
    public String toString() {
        return "Menu{" +
                "starter=" + starter +
                ", mainCourse=" + mainCourse +
                ", dessert=" + dessert +
                ", coffee=" + coffee +
                ", drink=" + drink +
                '}';
    }
}
