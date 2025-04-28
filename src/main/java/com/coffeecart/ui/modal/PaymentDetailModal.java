package com.coffeecart.ui.modal;

import com.coffeecart.ui.page.CartPage;
import com.coffeecart.ui.page.MenuPage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentDetailModal extends BaseModal {
    @Getter
    @FindBy(xpath = ".//input[@id='name']")
    private WebElement name;
    @Getter
    @FindBy(xpath = ".//input[@id='email']")
    private WebElement email;
    @Getter
    @FindBy(xpath = ".//button[@id='submit-payment']")
    private WebElement submitButton;
    @Getter
    @FindBy(xpath = ".//input[@id='promotion']")
    private WebElement subscriptionCheckbox;
    @Getter
    @FindBy(xpath = ".//section/button")
    private WebElement closeModalWindowButton;

    public PaymentDetailModal(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    @Step("Set Name Input {name}")
    public PaymentDetailModal enterName(String name) {
        waitUntilElementVisible(getName());
        getName().sendKeys(name);
        return this;
    }

    @Step("Set Email Input {email}")
    public PaymentDetailModal enterEmail(String email) {
        waitUntilElementVisible(getEmail());
        getEmail().sendKeys(email);
        return this;
    }

    @Step("Mark the check box")
    public PaymentDetailModal markCheckbox() {
        waitUntilElementVisible(getSubscriptionCheckbox());
        getSubscriptionCheckbox().click();
        return this;
    }

    @Step("Submit button click with valid values on the Menu page")
    public MenuPage clickSubmitButtonWithValidInput() {
        getSubmitButton().click();
        return new MenuPage(driver);
    }

    @Step("Submit button click with invalid values")
    public PaymentDetailModal clickSubmitButtonWithInvalidInput() {
        getSubmitButton().click();
        return this;
    }

    @Step("Submit button get text")
    public String getSubmitButtonText() {
        return getSubmitButton().getText();
    }

    @Step("Close modal window")
    public MenuPage closeModalWindowOnMenuPage() {
        getCloseModalWindowButton().click();
        return new MenuPage(driver);
    }

    @Step("Close modal window")
    public CartPage closeModalWindowOnCartPage() {
        getCloseModalWindowButton().click();
        return new CartPage(driver);
    }

}
