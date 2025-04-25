package com.coffeecart.ui.data;

import com.coffeecart.ui.elements.Drink;
import com.coffeecart.ui.elements.DrinkIngredient;
import lombok.Getter;

public enum DrinkEnum {
        ESPRESSO (new Drink("Espresso",
                new DrinkIngredient(Ingredients.ESPRESSO, 1))),
        ESPRESSO_MACCHIATO (new Drink("Espresso Macchiato",
                new DrinkIngredient(Ingredients.MILK_FOAM, 1),
                new DrinkIngredient(Ingredients.ESPRESSO, 1))),
        CAFFE_LATTE (new Drink("Caffe Latte",
                new DrinkIngredient(Ingredients.MILK_FOAM, 1),
                new DrinkIngredient(Ingredients.ESPRESSO, 1),
                new DrinkIngredient(Ingredients.STEAMED_MILK, 2))),
        AMERICANO (new Drink("Americano",
                new DrinkIngredient(Ingredients.WATER, 1),
                new DrinkIngredient(Ingredients.ESPRESSO, 1))),
        MOCHA (new Drink("Mocha",
                new DrinkIngredient(Ingredients.ESPRESSO, 1),
                new DrinkIngredient(Ingredients.WHIPPED_CREAM, 1),
                new DrinkIngredient(Ingredients.STEAMED_MILK, 1),
                new DrinkIngredient(Ingredients.CHOCOLATE_SYRUP, 1))),
        CAPPUCCINO (new Drink("Cappuccino",
                new DrinkIngredient(Ingredients.ESPRESSO, 1),
                new DrinkIngredient(Ingredients.STEAMED_MILK, 1),
                new DrinkIngredient(Ingredients.FOAMED_MILK, 1)));
    @Getter
    private Drink recipe;

    DrinkEnum(Drink recipe) {
        this.recipe = recipe;
    }

        public static String getName(DrinkEnum drink) {
            return drink.recipe.getName();
        }


    }
