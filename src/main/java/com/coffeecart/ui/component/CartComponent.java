package com.coffeecart.ui.component;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CartComponent extends BaseComponent {

    @Getter
    @FindBy(xpath = ".//div[contains(@class, 'short-item')]")
    private List<WebElement> shortItemElements;

    @FindBy(xpath = ".//div[contains(@class, 'total')]")
    private WebElement totalElement;

    public CartComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public List<ShortButtonComponent> getShortItems() {
        return shortItemElements.stream()
                .map(element -> new ShortButtonComponent(driver, element))
                .collect(Collectors.toList());
    }

    public double getTotalPrice() {
        String totalText = totalElement.getText().replace("Total: $", "").trim();
        return Double.parseDouble(totalText);
    }

    public boolean isVisible() {
        return rootElement.isDisplayed();
    }
}
