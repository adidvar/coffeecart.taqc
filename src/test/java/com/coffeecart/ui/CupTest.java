package com.coffeecart.ui;

import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.component.CupComponent;
import com.coffeecart.ui.data.DrinkEnum;
import com.coffeecart.ui.elements.Drink;
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

            WebElement cappuccinoCard = driver.findElement(
                    By.xpath("//li[.//*[@data-test='Cappuccino']]"));

            CardComponent cardComponent = new CardComponent(driver, cappuccinoCard);
            CupComponent cupComponent = cardComponent.getCupComponent();

            int actualLayerCount = cupComponent.getIngredientLayersCount();
            List<String> actualIngredients = cupComponent.getIngredientNames();

            System.out.println("Actual layer count: " + actualLayerCount);
            System.out.println("Actual ingredients: " + actualIngredients);

            softAssert.assertEquals(actualLayerCount, expectedIngredients.size(),
                    "Ingredient layers count mismatch");

            for (String expectedIngredient : expectedIngredients) {
                softAssert.assertTrue(actualIngredients.contains(expectedIngredient),
                        "Missing ingredient: " + expectedIngredient);
            }

            for (String actualIngredient : actualIngredients) {
                softAssert.assertTrue(expectedIngredients.contains(actualIngredient),
                        "Unexpected ingredient found: " + actualIngredient);
            }

            softAssert.assertAll();
        }
}
