package com.coffeecart.ui.component;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CupComponent extends BaseComponent{
    @Getter
    @FindBy(xpath = ".//div[contains(@class, 'cup-body')]")
    private WebElement cupBody;

    @FindBy(xpath = ".//div[contains(@class, 'ingredient')]")
    private List<WebElement> ingredientLayers;

    public CupComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public int getIngredientLayersCount() {
        return ingredientLayers.size();
    }

    public List<String> getIngredientNames() {
        return ingredientLayers.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList();
    }

    public boolean containsIngredient(String ingredientName) {
        return getIngredientNames().contains(ingredientName);
    }

}
