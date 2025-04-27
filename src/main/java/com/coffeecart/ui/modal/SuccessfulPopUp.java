package com.coffeecart.ui.modal;

import com.coffeecart.ui.elements.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfulPopUp extends BaseElement {
    @FindBy(xpath = ".//h2[contains(text(),'Thank you for your payment!')]")
    private WebElement successTitle;

    public SuccessfulPopUp(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public boolean isDisplayed() {
        waitUntilElementVisible(successTitle);
        return successTitle.isDisplayed();
    }

    public void waitUntilOpened() {
        waitUntilElementVisible(successTitle);
    }

    public void waitUntilClosed() {
        waitUntilElementInvisible(rootElement);
    }
}
