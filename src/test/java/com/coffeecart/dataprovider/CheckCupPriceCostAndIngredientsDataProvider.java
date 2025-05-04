package com.coffeecart.dataprovider;

import com.coffeecart.ui.data.Ingredients;
import com.coffeecart.ui.elements.Drink;
import com.coffeecart.ui.elements.DrinkIngredient;
import org.testng.annotations.DataProvider;

public class CheckCupPriceCostAndIngredientsDataProvider {

    @DataProvider(name = "checkCorrectCardPricesDataProvider")
    public Object[][] checkCorrectCardPricesDataProvider() {
        return new Object[][]{
                {"Espresso", 10.00},
                {"Espresso Macchiato", 12.00},
                {"Cappuccino", 19.00},
                {"Mocha", 8.00},
                {"Flat White", 18.00},
                {"Americano", 7.00},
                {"Cafe Latte", 16.00},
                {"Espresso Con Panna", 14.00},
                {"Cafe Breve", 15.00}
        };
    }
}
