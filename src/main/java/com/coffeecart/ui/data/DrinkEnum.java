package com.coffeecart.ui.data;

import com.coffeecart.ui.elements.Drink;
import com.coffeecart.ui.elements.DrinkIngredient;
import lombok.Getter;

public enum DrinkEnum {
    ESPRESSO(new Drink("Espresso",
            new DrinkIngredient(Ingredients.ESPRESSO, 30))),
    ESPRESSO_MACCHIATO(new Drink("Espresso Macchiato",
            new DrinkIngredient(Ingredients.MILK_FOAM, 15),
            new DrinkIngredient(Ingredients.ESPRESSO, 30))),
    CAPPUCCINO(new Drink("Cappuccino",
            new DrinkIngredient(Ingredients.MILK_FOAM, 50),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 20),
            new DrinkIngredient(Ingredients.ESPRESSO, 30))),
    MOCHA(new Drink("Mocha",
            new DrinkIngredient(Ingredients.WHIPPED_CREAM, 25),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 25),
            new DrinkIngredient(Ingredients.CHOCOLATE_SYRUP, 20),
            new DrinkIngredient(Ingredients.ESPRESSO, 30))),
    FLAT_WHITE(new Drink("Flat White",
            new DrinkIngredient(Ingredients.STEAMED_MILK, 50),
            new DrinkIngredient(Ingredients.ESPRESSO, 30))),
    AMERICANO(new Drink("Americano",
            new DrinkIngredient(Ingredients.WATER, 70),
            new DrinkIngredient(Ingredients.ESPRESSO, 30))),
    CAFFE_LATTE(new Drink("Caffe Latte",
            new DrinkIngredient(Ingredients.MILK_FOAM, 20),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 50),
            new DrinkIngredient(Ingredients.ESPRESSO, 30))),
    ESPRESSO_CON_PANNA(new Drink("Espresso Con Panna",
            new DrinkIngredient(Ingredients.WHIPPED_CREAM, 15),
            new DrinkIngredient(Ingredients.ESPRESSO, 30))),
    CAFE_BREVE(new Drink("Cafe Breve",
            new DrinkIngredient(Ingredients.MILK_FOAM, 15),
            new DrinkIngredient(Ingredients.STEAMED_CREAM, 30),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 30),
            new DrinkIngredient(Ingredients.ESPRESSO, 25)));


    @Getter
    private Drink recipe;

    DrinkEnum(Drink recipe) {
        this.recipe = recipe;
    }

    public static String getName(DrinkEnum drink) {
        return drink.recipe.getName();
    }


}
