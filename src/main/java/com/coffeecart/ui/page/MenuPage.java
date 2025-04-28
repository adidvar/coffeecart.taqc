package com.coffeecart.ui.page;

import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.modal.LuckyDayModal;
import com.coffeecart.ui.modal.PaymentDetailModal;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MenuPage extends BasePage {
    protected  LuckyDayModal luckyDayModal;
    protected PaymentDetailModal paymentDetailModal;

    @Getter
    private List<CardComponent> cards = new ArrayList<>();

    @Getter
    @FindBy(xpath="//*[@id='app']/div[2]/ul/li")
    private List<WebElement> rootCards ;

    @Getter
    @FindBy(xpath="//div[@class='modal']/div[@class='modal-content size']")
    private WebElement paymentModalRoot ;

    @Getter
    @FindBy(xpath="//div[@class='promo']")
    private WebElement luckyDayModalRoot ;

    @Getter
    @FindBy(xpath="//button[@class='pay']")
    private WebElement totalButton;

    public MenuPage(WebDriver driver) {
        super(driver);
        luckyDayModal = new LuckyDayModal(driver,luckyDayModalRoot);
        paymentDetailModal = new PaymentDetailModal(driver, paymentModalRoot);
        for(WebElement card: rootCards) {
            cards.add(new CardComponent(driver, card));
        }
    }
    public String getTotalButtonText() {
        return totalButton.getText();
    }
    public boolean isTotalButtonPresent() {
        return totalButton.isDisplayed();
    }

    public boolean isTotalButtonEnabled() {
        return totalButton.isEnabled();
    }
    @Step("Click 'Total' button")
    public PaymentDetailModal clickTotalButton() {
        totalButton.click();
        return new PaymentDetailModal(driver, paymentModalRoot);
    }
    @Step("Клік по чашці з назвою, що містить: {partialTitle}")
    public void clickCardByPartialTitle(String partialTitle) {
        for (CardComponent card : cards) {
            if (card.getName().contains(partialTitle)) {
                card.clickCup();
                break;
            }
        }

    }
    @Step("Клік по чашці  за назвою з очікуванням поп-апу")
    public LuckyDayModal clickCupWithPopUpByCardName(String partialTitle) {
        for (CardComponent card : cards) {
            if (card.getName().contains(partialTitle)) {
                card.clickCup();
                card.clickCup();
                card.clickCup();
                return new LuckyDayModal(driver, luckyDayModalRoot);
            }
        }
        return null;
    }
}
