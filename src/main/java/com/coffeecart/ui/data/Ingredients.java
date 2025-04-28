package com.coffeecart.ui.data;

public enum Ingredients {
    ESPRESSO("espresso"),
    MILK_FOAM("milk foam"),
    STEAMED_MILK("steamed milk"),
    WATER("water"),
    CHOCOLATE_SYRUP("chocolate syrup"),
    STEAMED_CREAM("steamed cream"),
    WHIPPED_CREAM("whipped cream");

    private final String name;

    Ingredients(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}

