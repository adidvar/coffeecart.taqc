package com.coffeecart.ui.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LuckyDayModal extends BaseModal {

    private WebElement title; // // «It's your lucky day! ...»

    private WebElement yesBtn; // «Yes, of course!»

    private WebElement skipBtn; // «Nah, I'll skip.»

    public LuckyDayModal(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public void clickYes() {
        clickDynamicElement(yesBtn);
    }

    public void clickSkip() {
        clickDynamicElement(skipBtn);
    }

    public boolean isDisplayed() {
        return title.isDisplayed();
    }

    /* ---------- Очікування появи / зникнення ---------- */

    public void waitUntilOpened() {
        waitUntilElementVisible(title);
    }

    public void waitUntilClosed() {
        waitUntilElementInvisible(rootElement);
    }
}
