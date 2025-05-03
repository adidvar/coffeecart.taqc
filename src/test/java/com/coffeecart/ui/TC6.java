package com.coffeecart.ui;

import com.coffeecart.ui.page.MenuPage;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.awt.*;

public class TC6  extends BaseTest{

    private final double delta = 0.0001f;

    @Test
    public void firstTest() {
        //@TODO add data provider for different coffee

        //@TODO fix and test

        double counter = (new MenuPage(driver)).getCardByName("Flat White").getCupComponent().clickOnCupBody().goToCartPage().clickOnTotalButton().enterName("test_name").enterEmail("test@gmail.com").clickSubmitButtonWithValidInput().getTotalButton().getMoneyCounter();
        Assert.assertEquals(counter,0.0,delta);
    }
}
