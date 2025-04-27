package com.coffeecart.ui;

import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.component.CupComponent;
import com.coffeecart.ui.data.Colors;
import com.coffeecart.ui.data.DrinkEnum;
import com.coffeecart.ui.elements.Drink;
import com.coffeecart.ui.elements.DrinkIngredient;
import com.coffeecart.ui.page.MenuPage;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CupTest extends BaseTestRunner {

    @Test
    public void verifyCappuccinoIngredients() {
        SoftAssert softAssert = new SoftAssert();

        Drink cappuccinoRecipe = DrinkEnum.CAPPUCCINO.getRecipe();
        List<String> expectedIngredients = cappuccinoRecipe.asCollection().stream()
                .map(drinkIngredient -> drinkIngredient.getIngredient().getName())
                .toList();

        System.out.println("Expected ingredients: " + expectedIngredients);

        MenuPage menuPage = new MenuPage(driver);

        CardComponent cappuccinoCard = menuPage.getCards().stream()
                .filter(card -> card.getName().equals("Cappuccino"))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Cappuccino card not found"));

        CupComponent cupComponent = cappuccinoCard.getCupComponent();

        List<String> actualIngredients = cupComponent.getIngredientNames();
        System.out.println("Actual ingredients found: " + actualIngredients);

        // Verify ingredient names
        for (String expectedIngredient : expectedIngredients) {
            boolean contains = actualIngredients.contains(expectedIngredient);
            softAssert.assertTrue(contains,
                    "Missing ingredient: " + expectedIngredient);
        }

        for (String actualIngredient : actualIngredients) {
            boolean expected = expectedIngredients.contains(actualIngredient);
            softAssert.assertTrue(expected,
                    "Unexpected ingredient found: " + actualIngredient);
        }

        // Verify ingredient quantities
        Map<String, String> actualHeights = cupComponent.getIngredientsWithHeights();

        for (DrinkIngredient expectedIngredient : cappuccinoRecipe.asCollection()) {
            String name = expectedIngredient.getName();
            String expectedHeight = String.valueOf(expectedIngredient.getQuantity());
            String actualHeightWithUnits = actualHeights.get(name);
            String actualHeight = actualHeightWithUnits.replaceAll("[^0-9]", "");

            System.out.println("Checking height for " + name + ":");
            System.out.println("  Expected: " + expectedHeight);
            System.out.println("  Actual:   " + actualHeight);

            softAssert.assertEquals(actualHeight, expectedHeight,
                    "Incorrect height for " + name);
        }

        // Verify ingredient colors
        List<String> actualColors = cupComponent.getIngredientColors();
        System.out.println("Actual ingredient colors: " + actualColors);

        softAssert.assertEquals(actualColors.size(), 3,
                "Number of color layers doesn't match expected");
        softAssert.assertEquals(actualColors.get(0), Colors.ESPRESSO_COLOR.getColor(),
                "Espresso layer color doesn't match expected");
        ;
        softAssert.assertEquals(actualColors.get(1), Colors.STEAMED_MILK_COLOR.getColor(),
                "Steamed milk layer color doesn't match expected");
        softAssert.assertEquals(actualColors.get(2), Colors.MILK_FOAM_COLOR.getColor(),
                "Milk foam layer color doesn't match expected");

        softAssert.assertAll();
    }
}
