package builderpattern.builderintefrace;

public interface AfterMainCourseStep {
    AfterMainCourseStep isVegan();
    AfterMainCourseStep isGlutenFree();
    AfterMainCourseStep withSupplement(String supplement);
    DrinkStep withDessert(String dessert);
    DrinkStep withCoffee(String coffee);
}
