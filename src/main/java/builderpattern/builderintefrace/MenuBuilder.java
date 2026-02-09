//package builderpattern.builderintefrace;
//
//import builderpattern.product.Menu;
//import builderpattern.product.dishes.Coffee;
//import builderpattern.product.dishes.Dish;
//import builderpattern.product.dishes.Drink;
//import builderpattern.product.dishes.MainCourse;
//
//public class MenuBuilder implements StarterStep, AfterStarterStep, AfterMainCourseStep, BuildStep, DrinkStep {
//    private Dish starter;
//    private MainCourse mainCourse;
//    private Dish dessert;
//    private Coffee coffee;
//    private Drink drink;
//
//    private MenuBuilder() {}
//
//    public static StarterStep newBuilder() {
//        return new MenuBuilder();
//    }
//
//
//    @Override
//    public AfterStarterStep withStarter(String starter) {
//        this.starter = new Dish(starter);
//        return this;
//    }
//
//    @Override
//    public AfterMainCourseStep withMainCourse(String mainCourse) {
//        this.mainCourse = new MainCourse(mainCourse);
//        return this;
//    }
//
//    @Override
//    public AfterMainCourseStep withSupplement(String supplement) {
//        mainCourse.addSupplement(supplement);
//        return this;
//    }
//
//    @Override
//    public BuildStep withCoffee(String coffee) {
//        this.coffee = new Coffee(coffee);
//        return this;
//    }
//
//    @Override
//    public BuildStep withDessert(String dessert) {
//        this.dessert = new Dish(dessert);
//        return this;
//    }
//
//    @Override
//    public BuildStep withDrink(String drink) {
//        this.drink = new Drink(drink);
//        return this;
//    }
//
//    @Override
//    public MenuBuilder isGlutenFree() {
//        if (mainCourse != null && starter == null) {
//            mainCourse.setGlutenFree();
//        } else if (starter != null) {
//            starter.setGlutenFree();
//        }
//        return this;
//    }
//
//    @Override
//    public MenuBuilder isVegan() {
//        if (mainCourse != null && starter == null) {
//            mainCourse.setVegan();
//        } else if (starter != null) {
//            starter.setVegan();
//        }
//        return this;
//    }
//
//    @Override
//    public Menu build() {
//        Menu menu = new Menu(this);
//        return menu;
//    }
//
//    // Getters
//    public Dish getStarter() {
//        return starter;
//    }
//
//    public MainCourse getMainCourse() {
//        return mainCourse;
//    }
//
//    public Dish getDessert() {
//        return dessert;
//    }
//
//    public Coffee getCoffee() {
//        return coffee;
//    }
//
//    public Drink getDrink() {
//        return drink;
//    }
//}
