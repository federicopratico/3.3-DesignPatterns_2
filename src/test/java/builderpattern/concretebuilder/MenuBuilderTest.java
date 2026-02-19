package builderpattern.concretebuilder;

import builderpattern.enums.Diet;
import builderpattern.product.Menu;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MenuBuilderTest {

    @Test
    void builder_allComponentsMenuAndCoffee_buildsSuccessfully() {
        Menu completeMenu = Menu.builder()
                .withStarter("Starter")
                .isGlutenFree()
                .isVegan()
                .withMainCourse("MainCourse")
                .isGlutenFree()
                .isVegan()
                .withSupplement("Supplement")
                .withCoffee("Coffee")
                .withDrink("Drink")
                .build();

        Set<Diet> starterDietFlags = completeMenu.getStarter().getDietFlag();
        Set<Diet> mainCourseDietFlags = completeMenu.getMainCourse().getDietFlag();

        assertNotNull(completeMenu);
        assertEquals("Starter", completeMenu.getStarter().getName());
        assertTrue(starterDietFlags.contains(Diet.VEGAN));
        assertTrue(starterDietFlags.contains(Diet.GLUTEN_FREE));
        assertEquals("MainCourse", completeMenu.getMainCourse().getName());
        assertTrue(mainCourseDietFlags.contains(Diet.VEGAN));
        assertTrue(mainCourseDietFlags.contains(Diet.GLUTEN_FREE));
        assertNull(completeMenu.getDessert());
        assertNotNull(completeMenu.getCoffee());
        assertEquals("Coffee", completeMenu.getCoffee().getName());
        assertEquals("Drink", completeMenu.getDrink().getName());
    }

    @Test
    void builder_allComponentsMenuAndDessert_buildsSuccessfully() {
        Menu completeMenu = Menu.builder()
                .withStarter("Starter")
                .isGlutenFree()
                .isVegan()
                .withMainCourse("MainCourse")
                .isGlutenFree()
                .isVegan()
                .withSupplement("Supplement")
                .withDessert("Dessert")
                .withDrink("Drink")
                .build();

        Set<Diet> starterDietFlags = completeMenu.getStarter().getDietFlag();
        Set<Diet> mainCourseDietFlags = completeMenu.getMainCourse().getDietFlag();

        assertNotNull(completeMenu);
        assertEquals("Starter", completeMenu.getStarter().getName());
        assertTrue(starterDietFlags.contains(Diet.VEGAN));
        assertTrue(starterDietFlags.contains(Diet.GLUTEN_FREE));
        assertEquals("MainCourse", completeMenu.getMainCourse().getName());
        assertTrue(mainCourseDietFlags.contains(Diet.VEGAN));
        assertTrue(mainCourseDietFlags.contains(Diet.GLUTEN_FREE));
        assertNull(completeMenu.getCoffee());
        assertNotNull(completeMenu.getDessert());
        assertEquals("Dessert", completeMenu.getDessert().getName());
        assertEquals("Drink", completeMenu.getDrink().getName());
    }

    @Test
    void build_halfMenu_buildSuccessfully() {
        Menu completeMenu = Menu.builder()
                .withMainCourse("MainCourse")
                .withSupplement("Supplement")
                .withDessert("Dessert")
                .withDrink("Drink")
                .build();

        assertNotNull(completeMenu);
        assertEquals("MainCourse", completeMenu.getMainCourse().getName());
        assertNotNull(completeMenu.getDessert());
        assertEquals("Dessert", completeMenu.getDessert().getName());
        assertEquals("Drink", completeMenu.getDrink().getName());
    }

    @Test
    void build_menuWithoutVeganOrGlutenFree_buildSuccessfully() {
        Menu completeMenu = Menu.builder()
                .withStarter("Starter")
                .withMainCourse("MainCourse")
                .withSupplement("Supplement")
                .withDessert("Dessert")
                .withDrink("Drink")
                .build();

        assertNotNull(completeMenu);
        assertEquals("Starter", completeMenu.getStarter().getName());
        assertEquals("MainCourse", completeMenu.getMainCourse().getName());
        assertNotNull(completeMenu.getDessert());
        assertEquals("Dessert", completeMenu.getDessert().getName());
        assertEquals("Drink", completeMenu.getDrink().getName());
    }
}