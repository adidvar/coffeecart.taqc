package com.coffeecart.ui;

import com.coffeecart.data.DrinkEnum;
import com.coffeecart.ui.page.MenuPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestSuccessfulPaymentClearCart extends BaseTest{

    @AfterMethod
    public void resetDriver() {
        driver.get(testValueProvider.getBaseUIUrl());
    }

    private final double delta = 0.0001f;

    @DataProvider(name = "drinkNames")
    public Object[][] provideDrinkNames() {
        return Arrays.stream(DrinkEnum.values())
                .map(drinkEnum -> new Object[]{DrinkEnum.getName(drinkEnum)})
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "drinkNames")
    public void testSuccessfulPaymentClearPrice(String drinkName) {
        double counter = (new MenuPage(driver)).clickDrink(drinkName).clickTotalButton().enterName(testValueProvider.getUserName()).enterEmail(testValueProvider.getUserEmail()).clickSubmitButtonWithValidInput().getButtonElement().getMoneyCounter();
        Assert.assertEquals(counter,0.0,delta);
    }

    @Test(dataProvider = "drinkNames")
    public void testSuccessfulPaymentClearCart(String drinkName) {
        int counter = (new MenuPage(driver)).clickDrink(drinkName).clickTotalButton().enterName(testValueProvider.getUserName()).enterEmail(testValueProvider.getUserEmail()).clickSubmitButtonWithValidInput().goToCartPage().getTotalNumberOfItemsFromCart();

        Assert.assertEquals(counter,0);
    }
}
