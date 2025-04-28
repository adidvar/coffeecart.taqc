package com.coffeecart.ui.discardLuckyProposition;

import com.coffeecart.ui.elements.TotalButtonElement;
import com.coffeecart.ui.page.MenuPage;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DiscardLuckyPropositionTest extends BaseTestRunner {
    MenuPage menuPage;
    TotalButtonElement totalButtonElement;

    @BeforeClass
    public void setUp() {
        super.beforeClass();
        menuPage = new MenuPage(driver);
        totalButtonElement = new TotalButtonElement(driver, menuPage.getTotalButton());
    }

    @Test
    public void testLuckyPropositionDiscard() {
        menuPage.getCards().stream()
                .filter(card -> card.getName().equals("Flat White"))
                .findFirst()
                .ifPresent(card -> card.getCupComponent().getCupBody().click());

        double total = 0;//totalButtonElement.getMoneyCounter();

        Assert.assertEquals(total, 18, "Total price for Flat White is incorrect");
    }
}
