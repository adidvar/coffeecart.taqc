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
    @Getter
    @FindBy(xpath = ".//section/button")
    private WebElement closeModalWindowButton;

    public PaymentDetailModal(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    @Step("Set Name Input {name}")
    public BaseModal enterName(String name) {
        waitUntilElementVisible(getName());
        getName().sendKeys(name);
        return this;
    }

    @Step("Set Email Input {email}")
    public BaseModal enterEmail(String email) {
        waitUntilElementVisible(getEmail());
        getEmail().sendKeys(email);
        return this;
    }

    @Step("Mark the check box")
    public BaseModal markCheckbox() {
        waitUntilElementVisible(getSubscriptionCheckbox());
        getSubscriptionCheckbox().click();
        return this;
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

    @Step("Close modal window")
    public MenuPage closeModalWindowButton() {
        waitUntilElementVisible(getCloseModalWindowButton());
        getCloseModalWindowButton().click();
        return new MenuPage(driver);
    }

}
