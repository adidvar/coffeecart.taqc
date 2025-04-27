package com.coffeecart.ui.modal;

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
    @FindBy(xpath = ".//input[@id='submit-payment']")
    private WebElement submitButton;
    @Getter
    @FindBy(xpath = ".//input[@id='promotion']")
    private WebElement subscriptionCheckbox;

    public PaymentDetailModal(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    @Step("Enter name")
    public void enterName(String name) {
        waitUntilElementVisible(getName());
        getName().sendKeys(name);
    }

    @Step("Enter email")
    public void enterEmail(String email) {
        waitUntilElementVisible(getEmail());
        getEmail().sendKeys(email);
    }

    @Step("Mark the check box")
    public void markCheckbox() {
        waitUntilElementVisible(getSubscriptionCheckbox());
        getSubscriptionCheckbox().click();
    }

    @Step("Submit button click with valid values")
    public MenuPage clickSubmitButtonValid() {
        waitUntilElementVisible(getSubmitButton());
        getSubmitButton().click();
        return new MenuPage(driver);
    }

    @Step("Submit button click with invalid values")
    public PaymentDetailModal clickSubmitButtonInValid() {
        waitUntilElementVisible(getSubmitButton());
        getSubmitButton().click();
        return this;
    }

    @Step("Submit button get text")
    public String getSubmitButtonText() {
        waitUntilElementVisible(getSubmitButton());
        return getSubmitButton().getText();
    }

}
