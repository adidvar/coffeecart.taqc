package com.coffeecart.ui.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddModal extends BaseModal {

    @FindBy(xpath = ".//h2[contains(text(), 'Add')]")
    private WebElement modalTitle;

    @FindBy(xpath = ".//button[contains(text(), 'Yes')]")
    private WebElement yesButton;

    @FindBy(xpath = ".//button[contains(text(), 'No')]")
    private WebElement noButton;

    public AddModal(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public String getFullModalText() {
        waitUntilElementVisible(modalTitle);
        return modalTitle.getText().trim();
    }

    public String getDrinkName() {
        String fullText = getFullModalText();
        if (fullText.startsWith("Add ") && fullText.endsWith(" to the cart?")) {
            return fullText
                    .replaceFirst("Add ", "")
                    .replaceFirst(" to the cart\\?", "")
                    .trim();
        }
        return "";
    }

    public void clickYes() {
        clickDynamicElement(yesButton);
    }

    public void clickNo() {
        clickDynamicElement(noButton);
    }

    public boolean isModalDisplayed() {
        try {
            return modalTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

