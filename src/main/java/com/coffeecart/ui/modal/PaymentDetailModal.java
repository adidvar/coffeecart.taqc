package com.coffeecart.ui.modal;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PaymentDetailModal extends BaseModal {
    //div[@class='modal']/div[@class='modal-content size']
    @FindBy(xpath = "./form[@id='name']")
    private WebElement name;
    @FindBy(xpath = "./form[@id='email']")
    private WebElement email;
    @FindBy(xpath = "./form[@id='submit-payment']")
    private WebElement submitButton;
    @FindBy(xpath = "./form[@id='promotion']")
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

    public void submit() {
        getSubmitButton().click();
    }

    public void markCheckbox(){
        getSubmitButton().click();
    }
    //happy -  menue
    //failed - this

}
