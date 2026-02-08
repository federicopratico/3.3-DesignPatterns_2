package builderpattern.builderintefrace;

public interface IAfterMainCourse {
    IAfterMainCourse isVegan();
    IAfterMainCourse isGlutenFree();
    IAfterMainCourse withSupplement(String supplement);
    ICanAddDrink withDessert(String dessert);
    ICanAddDrink withCoffee(String coffee);
}
