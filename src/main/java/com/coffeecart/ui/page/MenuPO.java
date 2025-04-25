package com.coffeecart.ui.page;

import com.coffeecart.ui.component.CardComponent;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MenuPO extends BasePage {
    @Getter
    private List<CardComponent> cards = new ArrayList<>();;

    @FindBy(xpath="//*[@id='app']/div[2]/ul/li")
    private List<WebElement> rootCards ;

    public MenuPO(WebDriver driver) {
        super(driver);

        for(WebElement card: rootCards) {
            cards.add(new CardComponent(driver, card));
        }
    }
}
