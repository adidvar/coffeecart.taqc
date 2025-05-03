package com.coffeecart.ui.discardLuckyProposition;

import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.component.ShortItemComponent;
import com.coffeecart.ui.elements.TotalButtonElement;
import com.coffeecart.ui.page.MenuPage;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Optional;

public class TestCaseVerifyLuckyPropositionDiscard extends BaseTestRunner {
    MenuPage menuPage;
    TotalButtonElement totalButtonElement;

    @BeforeClass
    public void setUp() {
        super.beforeClass();
        menuPage = new MenuPage(driver);
        totalButtonElement = new TotalButtonElement(driver, menuPage.getTotalButton());
    }

    public void selectDrink(String drinkName){
        Optional<CardComponent> cardComponent = menuPage.getCards().stream()
                .filter(card -> card.getName().equals(drinkName))
                .findFirst();

        cardComponent.ifPresent(component -> component.getCupComponent().getCupBody().click());
        //return this
    }

    public void testLuckyPropositionDiscard() {

        List<ShortItemComponent> items = menuPage
                .getButtonElement()
                .hoverTotalButton()
                .getShortItems();
        Optional<ShortItemComponent> latteItem = items.stream()
                .filter(item -> item.getName().equalsIgnoreCase("Flat White"))
                .findFirst();

        int amount = 0;
        if (latteItem.isPresent()) {
            amount = latteItem.get().getCount();
        }

        double total = menuPage.getButtonElement().getMoneyCounter();

        Assert.assertEquals(total, 18.0, "Total price for Flat White is incorrect");
        Assert.assertEquals(amount, 1, "Amount of Flat White drink is incorrect");
    }
}
