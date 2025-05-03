package com.coffeecart.ui.page;

import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.elements.TotalButtonElement;
import com.coffeecart.ui.modal.LuckyDayModal;
import com.coffeecart.ui.modal.PaymentDetailModal;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @FindBy(xpath="//*[@class=\"pay-container\"]")
    private WebElement payContainer;

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

    public TotalButtonElement getButtonElement(){
        return new TotalButtonElement(driver,getPayContainer());
    }
}
