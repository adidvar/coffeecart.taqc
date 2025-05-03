package com.coffeecart.ui.page;

import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.component.LuckyDayComponent;
import com.coffeecart.ui.modal.PaymentDetailModal;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MenuPage extends BasePage {
    protected LuckyDayComponent luckyDayComponent;
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
        luckyDayComponent = new LuckyDayComponent(driver,luckyDayModalRoot);
        paymentDetailModal = new PaymentDetailModal(driver, paymentModalRoot);
        for(WebElement card: rootCards) {
            cards.add(new CardComponent(driver, card));
        }
    }

    public MenuPage clickDrink(String drinkName) {
        getCards().stream()
                .filter(card -> card.getName().equals(drinkName))
                .findFirst()
                .ifPresent(component -> component.getCupComponent().getCupBody().click());
        return this;
    }
}
