package com.coffeecart.ui.modal;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PaymentDetail extends BaseModal {
    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "submit-payment")
    private WebElement submitButton;
    @FindBy(id = "promotion")
    private WebElement subscriptionCheckbo;

    public PaymentDetail(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public void enterName(String name) {
        getName().sendKeys(name);
    }

    public void enterEmail(String email) {
        getEmail().sendKeys(email);
    }

    public void submit() {
        getSubmitButton().click();
    }

    public void markCheckbox(){
        getSubmitButton().click();
    }

}
