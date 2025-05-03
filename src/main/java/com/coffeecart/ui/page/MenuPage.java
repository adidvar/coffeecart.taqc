package com.coffeecart.ui.page;

import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.component.LuckyDayComponent;
import com.coffeecart.ui.elements.TotalButtonElement;
import com.coffeecart.ui.modal.PaymentDetailModal;
import io.qameta.allure.Step;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MenuPage extends BasePage {
    TotalButtonElement totalButton;
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
    private WebElement totalButtonRoot;

    @Getter
    @FindBy(xpath="//*[@class=\"pay-container\"]")
    private WebElement payContainer ;

    public MenuPage(WebDriver driver) {
        super(driver);
        totalButton = new TotalButtonElement(driver,totalButtonRoot);
        for(WebElement card: rootCards) {
            cards.add(new CardComponent(driver, card));
        }
    }

    @Step("Click 'Total' button")
    public PaymentDetailModal clickTotalButton() {
        return totalButton.clickTotalButton();
    }

    public TotalButtonElement getButtonElement(){
        return totalButton;
    }

    public LuckyDayComponent getGetLackyDayComponent(){
        return new LuckyDayComponent(driver,getLuckyDayModalRoot());
    }

    @Step("Click on cup with title: {drinkName}")
    public MenuPage clickDrink(String drinkName) {
        getCards().stream()
                .filter(card -> card.getName().equals(drinkName))
                .findFirst()
                .ifPresent(component -> component.getCupComponent().clickOnCupBody());
        return this;
    }

    @Step("Navigate to the Cart Page")
    public CartPage goToCartPage() {
        return header.navigateToCart();
    }

    @Step("Navigate to the GitHub Page")
    public GitHubPage goToGitHubPage() {
        return header.navigateToGitHub();
    }
}
