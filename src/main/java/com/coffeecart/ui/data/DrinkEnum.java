package com.coffeecart.ui.data;

import com.coffeecart.ui.elements.Drink;
import com.coffeecart.ui.elements.DrinkIngredient;
import lombok.Getter;

public enum DrinkEnum {
    ESPRESSO(new Drink("Espresso",
            new DrinkIngredient(Ingredients.ESPRESSO, 1))),
    ESPRESSO_MACCHIATO(new Drink("Espresso Macchiato",
            new DrinkIngredient(Ingredients.ESPRESSO, 1),
            new DrinkIngredient(Ingredients.MILK_FOAM, 1))),
    CAPPUCCINO(new Drink("Cappuccino",
            new DrinkIngredient(Ingredients.ESPRESSO, 1),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 1),
            new DrinkIngredient(Ingredients.MILK_FOAM, 1))),
    MOCHA(new Drink("Mocha",
            new DrinkIngredient(Ingredients.ESPRESSO, 1),
            new DrinkIngredient(Ingredients.CHOCOLATE_SYRUP, 1),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 1),
            new DrinkIngredient(Ingredients.WHIPPED_CREAM, 1))),
    FLAT_WHITE(new Drink("Flat White",
            new DrinkIngredient(Ingredients.ESPRESSO, 1),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 1))),
    AMERICANO(new Drink("Americano",
            new DrinkIngredient(Ingredients.ESPRESSO, 1),
            new DrinkIngredient(Ingredients.WATER, 1))),
    CAFFE_LATTE(new Drink("Caffe Latte",
            new DrinkIngredient(Ingredients.ESPRESSO, 1),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 1),
            new DrinkIngredient(Ingredients.MILK_FOAM, 1))),
    ESPRESSO_CON_PANNA(new Drink("Espresso Con Panna",
            new DrinkIngredient(Ingredients.ESPRESSO, 1),
            new DrinkIngredient(Ingredients.WHIPPED_CREAM, 1))),
    CAFE_BREVE(new Drink("Cafe Breve",
            new DrinkIngredient(Ingredients.ESPRESSO, 1),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 1),
            new DrinkIngredient(Ingredients.STEAMED_CREAM, 1),
            new DrinkIngredient(Ingredients.MILK_FOAM, 1)));


    @Getter
    private Drink recipe;

    DrinkEnum(Drink recipe) {
        this.recipe = recipe;
    }

    public static String getName(DrinkEnum drink) {
        return drink.recipe.getName();
    }


}
