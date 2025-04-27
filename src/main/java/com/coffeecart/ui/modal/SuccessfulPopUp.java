package com.coffeecart.ui.modal;

import com.coffeecart.ui.elements.BaseElement;
import com.coffeecart.ui.page.MenuPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfulPopUp extends BaseElement {
    @Getter
    @FindBy(xpath = ".//h2")
    private WebElement successTitle;

    public SuccessfulPopUp(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public boolean isDisplayed() {
        return successTitle.isDisplayed();
    }

    public void waitUntilOpened() {
        waitUntilElementVisible(successTitle);
    }

    public MenuPage waitUntilClosed() {
        waitUntilElementInvisible(rootElement);
        return new MenuPage(driver);
    }
}
