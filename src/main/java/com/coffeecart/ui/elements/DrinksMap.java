package com.coffeecart.ui.elements;

import com.coffeecart.ui.data.DrinkEnum;

import java.util.Collection;
import java.util.TreeMap;

public class DrinksMap extends TreeMap<String, Drink> {

    public DrinksMap() {
        for (DrinkEnum r : DrinkEnum.values()) {
            put(r.getRecipe().getName(), r.getRecipe());
        }
    }

    public double getPrice(DrinkEnum e) {
        return get(e.getRecipe().getName()).getPrice();
    }

    public Collection<Drink> asCollection() {
        return this.values();
    }
    public Drink getRecipeByName(String drinkName) {
        for (Drink r : asCollection()) {
            if (r.getName().equalsIgnoreCase(drinkName)) {
                return r;
            }
        }
        return null;
    }
    public Drink getRecipeByOrdinal(int n) {
        int count = 0;
        for (Drink r : asCollection()) {
            if (count == n) return r;
            ++count;
        }
        return null;
    }
}
