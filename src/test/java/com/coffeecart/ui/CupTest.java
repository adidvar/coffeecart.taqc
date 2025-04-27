package com.coffeecart.ui;

import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.component.CupComponent;
import com.coffeecart.ui.data.Colors;
import com.coffeecart.ui.data.DrinkEnum;
import com.coffeecart.ui.elements.Drink;
import com.coffeecart.ui.page.MenuPage;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

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

        System.out.println("Actual ingredients: " + actualIngredients);

        for (String expectedIngredient : expectedIngredients) {
            softAssert.assertTrue(actualIngredients.contains(expectedIngredient),
                    "Missing ingredient: " + expectedIngredient);
        }

        for (String actualIngredient : actualIngredients) {
            softAssert.assertTrue(expectedIngredients.contains(actualIngredient),
                    "Unexpected ingredient found: " + actualIngredient);
        }

        List<String> actualColors = cupComponent.getIngredientColors();
        System.out.println("Actual ingredient colors: " + actualColors);

        softAssert.assertEquals(actualColors.size(), 3,
                "Кількість шарів кольорів не відповідає очікуваній");

        softAssert.assertEquals(actualColors.size(), 3,
                "Number of color layers doesn't match expected");

        softAssert.assertEquals(actualColors.get(0), Colors.ESPRESSO_COLOR.getColor(),
                "Espresso layer color doesn't match expected");

        softAssert.assertEquals(actualColors.get(1), Colors.STEAMED_MILK_COLOR.getColor(),
                "Steamed milk layer color doesn't match expected");

        softAssert.assertEquals(actualColors.get(2), Colors.MILK_FOAM_COLOR.getColor(),
                "Milk foam layer color doesn't match expected");

        softAssert.assertAll();
    }
}
