package com.coffeecart.ui.modal;

import com.coffeecart.ui.component.CupComponent;
import com.coffeecart.ui.page.MenuPage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LuckyDayModal extends BaseModal {

    @Getter
    @FindBy(xpath = ".//span")
    private WebElement title;

    @Getter
    @FindBy(xpath = ".//button[contains(@class,'yes')]")
    private WebElement yesBtn;

    @Getter
    @FindBy(xpath = ".//button[not(contains(@class,'yes'))]")
    private WebElement skipBtn;

    @Getter
    @FindBy(xpath = ".//div[contains(@class,'cup-body')]")
    private WebElement cupRoot;

    private final CupComponent cupComponent;

    public LuckyDayModal(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        this.cupComponent = new CupComponent(driver, cupRoot);
    }

    @Step("Click «Yes, of course!»")
    public MenuPage clickYes() {
        clickDynamicElement(yesBtn);
        waitUntilClosed();
        return new MenuPage(driver);
    }

    @Step("Click «Nah, I'll skip.»")
    public MenuPage clickSkip() {
        clickDynamicElement(skipBtn);
        waitUntilClosed();
        return new MenuPage(driver);
    }

    public boolean isDisplayed() { return title.isDisplayed(); }

    /** Чекаємо появи модалки */
    public void waitUntilOpened() { waitUntilElementVisible(title); }

    /** Чекаємо зникнення модалки */
    public void waitUntilClosed() { waitUntilElementInvisible(rootElement); }

}
