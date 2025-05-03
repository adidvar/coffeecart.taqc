package com.coffeecart.ui.discardLuckyProposition;

import com.coffeecart.ui.component.ShortItemComponent;
import com.coffeecart.ui.elements.TotalButtonElement;
import com.coffeecart.ui.page.MenuPage;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

@Slf4j
public class DiscardLuckyPropositionTest extends BaseTestRunner {
    MenuPage menuPage;
    TotalButtonElement totalButtonElement;

    @BeforeClass
    public void setUp() {
        super.beforeClass();
        menuPage = new MenuPage(driver);
        totalButtonElement = new TotalButtonElement(driver, menuPage.getPaymentModalRoot());
    }

    @Test
    public void testLuckyPropositionDiscard() {
        List<ShortItemComponent> items = menuPage
                .clickDrink("Flat White")
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
