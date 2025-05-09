package com.coffeecart.ui.modal;

import com.coffeecart.ui.data.Colors;
import com.coffeecart.ui.page.CartPage;
import com.coffeecart.ui.page.MenuPage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentDetailModal extends BaseModal {
    @Getter
    @FindBy(xpath = ".//h1")
    private WebElement header;
    @Getter
    @FindBy(xpath = ".//p")
    private WebElement paragraph;
    @Getter
    @FindBy(xpath = ".//label[@for='name']")
    private WebElement labelName;
    @Getter
    @FindBy(xpath = ".//input[@id='name']")
    private WebElement inputName;
    @Getter
    @FindBy(xpath = ".//label[@for='email']")
    private WebElement labelEmail;
    @Getter
    @FindBy(xpath = ".//input[@id='email']")
    private WebElement inputEmail;
    @Getter
    @FindBy(xpath = ".//label[@id='promotion-label']")
    private WebElement labelCheckbox;
    @Getter
    @FindBy(xpath = ".//input[@id='promotion']")
    private WebElement inputCheckbox;
    @Getter
    @FindBy(xpath = ".//button[@id='submit-payment']")
    private WebElement submitButton;
    @Getter
    @FindBy(xpath = ".//section/button")
    private WebElement closeModalWindowButton;
    @Getter
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div")
    private WebElement paymentModal;


    public PaymentDetailModal(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public String getHeaderText() {
        return header.getText();
    }

    public String getParagraphText() {
        return paragraph.getText();
    }

    public String getLabelNameText() {
        return labelName.getText();
    }

    public String getLabelEmailText() {
        return labelEmail.getText();
    }

    public String getLabelCheckboxText() {
        return labelCheckbox.getText();
    }

    public String getSubmitButtonText() {
        return submitButton.getText();
    }

    @Step("Set Name Input {name}")
    public PaymentDetailModal enterName(String name) {
        waitUntilElementVisible(inputName);
        inputName.sendKeys(name);
        return this;
    }

    @Step("Set Email Input {email}")
    public PaymentDetailModal enterEmail(String email) {
        waitUntilElementVisible(inputEmail);
        inputEmail.sendKeys(email);
        return this;
    }

    public boolean isCheckboxMarked() {
        String gtmValue = inputCheckbox.getAttribute("data-gtm-form-interact-field-id");
        if ("2".equals(gtmValue)) {
            return true;
        }
        return false;
    }

    @Step("Mark the check box")
    public PaymentDetailModal markCheckbox() {
        waitUntilElementVisible(inputCheckbox);
        inputCheckbox.click();
        return this;
    }

    @Step("Submit button click with valid values on the Menu page")
    public SuccessfulPopUp clickSubmitButtonWithValidInput() {
        getSubmitButton().click();
        return new SuccessfulPopUp(driver);
    }

    @Step("Submit button click with invalid values")
    public PaymentDetailModal clickSubmitButtonWithInvalidInput() {
        getSubmitButton().click();
        return this;
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
