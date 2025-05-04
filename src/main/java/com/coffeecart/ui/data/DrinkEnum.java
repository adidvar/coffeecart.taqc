package com.coffeecart.ui.data;

import com.coffeecart.ui.elements.Drink;
import com.coffeecart.ui.elements.DrinkIngredient;
import lombok.Getter;

public enum DrinkEnum {
    ESPRESSO(new Drink("Espresso", "特浓咖啡",
            new DrinkIngredient(Ingredients.ESPRESSO, 1))),
    ESPRESSO_MACCHIATO(new Drink("Espresso Macchiato", "浓缩玛奇朵",
            new DrinkIngredient(Ingredients.MILK_FOAM, 1),
            new DrinkIngredient(Ingredients.ESPRESSO, 1))),
    CAPPUCCINO(new Drink("Cappuccino", "卡布奇诺",
            new DrinkIngredient(Ingredients.MILK_FOAM, 2),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 1),
            new DrinkIngredient(Ingredients.ESPRESSO, 1))),
    MOCHA(new Drink("Mocha", "摩卡",
            new DrinkIngredient(Ingredients.WHIPPED_CREAM, 1),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 1),
            new DrinkIngredient(Ingredients.CHOCOLATE_SYRUP, 1),
            new DrinkIngredient(Ingredients.ESPRESSO, 1))),
    FLAT_WHITE(new Drink("Flat White", "平白咖啡",
            new DrinkIngredient(Ingredients.STEAMED_MILK, 2),
            new DrinkIngredient(Ingredients.ESPRESSO, 1))),
    AMERICANO(new Drink("Americano", "美式咖啡",
            new DrinkIngredient(Ingredients.WATER, 3),
            new DrinkIngredient(Ingredients.ESPRESSO, 1))),
    CAFFE_LATTE(new Drink("Caffe Latte", "拿铁",
            new DrinkIngredient(Ingredients.MILK_FOAM, 1),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 2),
            new DrinkIngredient(Ingredients.ESPRESSO, 1))),
    ESPRESSO_CON_PANNA(new Drink("Espresso Con Panna", "浓缩康宝蓝",
            new DrinkIngredient(Ingredients.WHIPPED_CREAM, 1),
            new DrinkIngredient(Ingredients.ESPRESSO, 1))),
    CAFE_BREVE(new Drink("Cafe Breve", "半拿铁",
            new DrinkIngredient(Ingredients.WHIPPED_CREAM, 1),
            new DrinkIngredient(Ingredients.STEAMED_CREAM, 1),
            new DrinkIngredient(Ingredients.STEAMED_MILK, 1),
            new DrinkIngredient(Ingredients.ESPRESSO, 1)));


    @Getter
    private Drink recipe;

    DrinkEnum(Drink recipe) {
        this.recipe = recipe;
    }

    public static String getName(DrinkEnum drink) {
        return drink.recipe.getName();
    }
    public static String getChineseName(DrinkEnum drink) {
        return drink.recipe.getChineseName();
    }

}
