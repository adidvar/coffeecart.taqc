package com.coffeecart.ui.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CardComponent extends BaseComponent {
    private String name;
    private double price;
    private CupComponent cupComponent;

    public CardComponent(WebDriver driver, WebElement rootElement, String name, double price, CupComponent cupComponent) {
        super(driver, rootElement);
        this.name = name;
        this.price = price;
        this.cupComponent = cupComponent;
    }
}
