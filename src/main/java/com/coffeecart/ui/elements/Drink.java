package com.coffeecart.ui.elements;

import com.coffeecart.ui.data.Ingredients;
import lombok.Getter;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Drink {

    @Getter
    private Map<String, DrinkIngredient> drinkIngredients = new LinkedHashMap<>();

    @Getter
    private String name;

    public Drink(String name, DrinkIngredient... drinkIngredientList) {
        this.name = name;
        drinkIngredients = new LinkedHashMap<>();
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
        return drinkIngredients.values()
                .stream()
                .map(DrinkIngredient::getIngredient)
                .collect(Collectors.toList());
    }

}
