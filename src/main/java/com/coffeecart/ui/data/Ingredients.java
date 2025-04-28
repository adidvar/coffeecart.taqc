package com.coffeecart.ui.data;

public enum Ingredients {
    ESPRESSO("espresso",10),
    MILK_FOAM("milk foam",2),
    STEAMED_MILK("steamed milk",1.6),
    WATER("water",1),
    CHOCOLATE_SYRUP("chocolate syrup",2),
    STEAMED_CREAM("steamed cream",2),
    WHIPPED_CREAM("whipped cream",4);

    private final String name;
    private final double unit_cost;

     Ingredients(String name, double unit_cost) {
        this.name = name;
        this.unit_cost = unit_cost;
    }
    public String getName() {
        return name;
    }

    public double getCost() {
        return unit_cost;
    }

}

