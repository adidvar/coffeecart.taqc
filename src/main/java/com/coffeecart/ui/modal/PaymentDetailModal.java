package com.coffeecart.ui.modal;

import com.coffeecart.ui.page.MenuPage;
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

    public void enterName(String name) {
        getName().sendKeys(name);
    }

    public void enterEmail(String email) {
        getEmail().sendKeys(email);
    }

    public void markCheckbox() {
        getSubmitButton().click();
    }

    public MenuPage clickSubmitButtonValid() {
        waitUntilElementVisible(submitButton);
        submitButton.click();
        return new MenuPage(driver);
    }

    public PaymentDetailModal clickSubmitButtonInValid() {
        waitUntilElementVisible(submitButton);
        submitButton.click();
        return this;
    }

    public String getSubmitButtonText() {
        return submitButton.getText();
    }

}
