package builderpattern.product.dishes;

public class MainCourse extends Dish {
    private String supplement;

    public MainCourse(String name) {
        super(name);
    }

    public void addSupplement(String supplement) {
        this.supplement = supplement;
    }


}
