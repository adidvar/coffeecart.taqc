package com.coffeecart.ui;

import com.coffeecart.ui.data.DrinkEnum;
import com.coffeecart.ui.data.Ingredients;
import com.coffeecart.ui.elements.Drink;
import com.coffeecart.ui.elements.DrinksMap;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;


public class BaseTest extends BaseTestRunner {
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void firstTest() {


    }
    private DrinksMap recipes;

    @Test
    public void testRecipeOrder() {
        recipes = new DrinksMap();
        String recipeNames[] = {
                DrinkEnum.getName(DrinkEnum.AMERICANO),
                DrinkEnum.getName(DrinkEnum.CAFE_BREVE),
                DrinkEnum.getName(DrinkEnum.CAFFE_LATTE),
                DrinkEnum.getName(DrinkEnum.CAPPUCCINO),
                DrinkEnum.getName(DrinkEnum.ESPRESSO),
                DrinkEnum.getName(DrinkEnum.ESPRESSO_CON_PANNA),
                DrinkEnum.getName(DrinkEnum.ESPRESSO_MACCHIATO),
                DrinkEnum.getName(DrinkEnum.FLAT_WHITE),
                DrinkEnum.getName(DrinkEnum.MOCHA)

        };
        int count = 0;
        for (Drink r : recipes.asCollection()) {
            assertEquals(r.getName(), recipeNames[count++]);
        }
    }
    @Test
    public void testQuantities() {
        softAssert.assertEquals(DrinkEnum.AMERICANO.getRecipe().getIngredientQuantity(Ingredients.ESPRESSO), 1, "Кількість Espresso в Americano неправильна");
        softAssert.assertEquals(DrinkEnum.AMERICANO.getRecipe().getIngredientQuantity(Ingredients.WATER), 1, "Кількість Water в Americano неправильна");
        softAssert.assertEquals(DrinkEnum.CAPPUCCINO.getRecipe().getIngredientQuantity(Ingredients.MILK_FOAM), 1, "Кількість Milk Foam в Cappuccino неправильна");
        softAssert.assertEquals(DrinkEnum.CAPPUCCINO.getRecipe().getIngredientQuantity(Ingredients.ESPRESSO), 1, "Кількість Espresso в Cappuccino неправильна");
        softAssert.assertEquals(DrinkEnum.CAPPUCCINO.getRecipe().getIngredientQuantity(Ingredients.STEAMED_MILK), 1, "Кількість Steamed Milk в Cappuccino неправильна");
        softAssert.assertAll();
    }

@Test
public void testRecipeIngredientsOrder() {
    List<String> expectedEspressoIngredients = Arrays.asList("espresso");
    List<String> expectedEspressoMacchiatoIngredients = Arrays.asList("espresso", "milk foam");
    List<String> expectedCappuccinoIngredients = Arrays.asList("espresso", "steamed milk", "milk foam");
    List<String> expectedMochaIngredients = Arrays.asList("espresso", "chocolate syrup", "steamed milk", "whipped cream");
    List<String> expectedFlatWhiteIngredients = Arrays.asList("espresso", "steamed milk");
    List<String> expectedAmericanoIngredients = Arrays.asList("espresso", "water");
    List<String> expectedCaffeLatteIngredients = Arrays.asList("espresso", "steamed milk", "milk foam");
    List<String> expectedEspressoConPannaIngredients = Arrays.asList("espresso", "whipped cream");
    List<String> expectedCafeBreveIngredients = Arrays.asList("espresso", "steamed milk", "steamed cream", "milk foam");


    softAssert.assertEquals(getIngredientNames(DrinkEnum.ESPRESSO.getRecipe().getIngredients()), expectedEspressoIngredients, "Інгредієнти для Espresso неправильні");
    softAssert.assertEquals(getIngredientNames(DrinkEnum.ESPRESSO_MACCHIATO.getRecipe().getIngredients()), expectedEspressoMacchiatoIngredients, "Інгредієнти для Espresso Macchiato неправильні");
    softAssert.assertEquals(getIngredientNames(DrinkEnum.CAPPUCCINO.getRecipe().getIngredients()), expectedCappuccinoIngredients, "Інгредієнти для Cappuccino неправильні");
    softAssert.assertEquals(getIngredientNames(DrinkEnum.MOCHA.getRecipe().getIngredients()), expectedMochaIngredients, "Інгредієнти для Mocha неправильні");
    softAssert.assertEquals(getIngredientNames(DrinkEnum.FLAT_WHITE.getRecipe().getIngredients()), expectedFlatWhiteIngredients, "Інгредієнти для Flat White неправильні");
    softAssert.assertEquals(getIngredientNames(DrinkEnum.AMERICANO.getRecipe().getIngredients()), expectedAmericanoIngredients, "Інгредієнти для Americano неправильні");
    softAssert.assertEquals(getIngredientNames(DrinkEnum.CAFFE_LATTE.getRecipe().getIngredients()), expectedCaffeLatteIngredients, "Інгредієнти для Caffe Latte неправильні");
    softAssert.assertEquals(getIngredientNames(DrinkEnum.ESPRESSO_CON_PANNA.getRecipe().getIngredients()), expectedEspressoConPannaIngredients, "Інгредієнти для Espresso Con Panna неправильні");
    softAssert.assertEquals(getIngredientNames(DrinkEnum.CAFE_BREVE.getRecipe().getIngredients()), expectedCafeBreveIngredients, "Інгредієнти для Cafe Breve неправильні");

    softAssert.assertAll();
    }
    private List<String> getIngredientNames(List<Ingredients> ingredientsList) {
        return ingredientsList.stream()
                .map(Ingredients::getName) // Берем только имена ингредиентов
                .collect(Collectors.toList());
    }
    /*
    @Test
    public void testRecipeCosts() {
        double expected = 3.0 * ingredients.getCost(Ingredients.ESPRESSO);
        double actual = recipes.getPrice(DrinkEnum.ESPRESSO);
        assertEquals(expected, actual, 0.001);

    }

 */
}








