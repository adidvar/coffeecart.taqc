package com.coffeecart.ui.page;

import com.coffeecart.ui.component.CardComponent;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MenuPage extends BasePage {
    @Getter
    private List<CardComponent> cards = new ArrayList<>();

    @Getter
    @FindBy(xpath="//*[@id='app']/div[2]/ul/li")
    private List<WebElement> rootCards ;

    @Getter
    @FindBy(xpath="//div[@class='modal']/div[@class='modal-content size']")
    private WebElement paymentModalRoot ;

    @Getter
    @FindBy(xpath="//button[@class='pay']")
    private WebElement totalButton;



    public MenuPage(WebDriver driver) {
        super(driver);

        for(WebElement card: rootCards) {
            cards.add(new CardComponent(driver, card));
        }
    }
}
