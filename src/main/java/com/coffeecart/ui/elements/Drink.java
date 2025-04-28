package com.coffeecart.ui.elements;

import com.coffeecart.ui.data.Ingredients;
import lombok.Getter;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drink {
    @Getter
    private Map<String, DrinkIngredient> drinkIngredients;

    @Getter
    private String name;

    public Drink(String name, DrinkIngredient... drinkIngredientList) {
        this.name = name;
        drinkIngredients = new HashMap<String, DrinkIngredient>();
        for (DrinkIngredient d : drinkIngredientList) {
            drinkIngredients.put(d.getIngredient().getName(), d);
        }
    }
    public Collection<DrinkIngredient> asCollection() {
        return drinkIngredients.values();
    }
    public int getIngredientQuantity(String ingredientName) {
        return drinkIngredients.get(ingredientName).getQuantity();
    }

    public int getIngredientQuantity(Ingredients ingredients) {
        return getIngredientQuantity(ingredients.getName());
    }
    public List<Ingredients> getIngredients() {
        return drinkIngredients.values().stream()
                .map(DrinkIngredient::getIngredient)  // Отримуємо інгредієнт з кожного DrinkIngredient
                .toList();  // Перетворюємо потік на список
    }
    public double getPrice() {
        double sum = 0.0;
        for (DrinkIngredient d : asCollection()) {
            sum += (double)d.getQuantity() * d.getIngredient().getCost();
        }
        return sum;
    }
    public String getFormattedPrice() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(getPrice());
    }
}
