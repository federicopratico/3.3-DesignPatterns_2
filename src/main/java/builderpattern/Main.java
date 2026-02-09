package builderpattern;

import builderpattern.product.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = Menu.builder()
                .withMainCourse("Pizza")
                .withSupplement("Patate fritte")
                .withDessert("Tiramisu")
                .withDrink("cocacola")
                .build();

        System.out.println(menu);
    }
}
