package com.coffeecart.ui;

import com.coffeecart.data.DrinkEnum;
import com.coffeecart.ui.elements.Drink;
import com.coffeecart.ui.page.CartPage;
import com.coffeecart.ui.page.MenuPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TC18 extends BaseTest {
    @AfterMethod
    public void resetDriver() {
        driver.get(testValueProvider.getBaseUIUrl());
    }

    private final double delta = 0.0001f;

    @Test
    public void testCartComponentHiddenOnMenu() {
        try {
            var cartComponent = new MenuPage(driver)
                    .getButtonElement().hoverTotalButton();

            Assert.fail("Menu shows for empty cart");
        } catch (TimeoutException e) {
        }
    }

    @Test
    public void testCartComponentVisibleOnMenu() {
        var cartComponent = new MenuPage(driver).clickDrink(DrinkEnum.getName(DrinkEnum.CAFE_BREVE))
                .getButtonElement().hoverTotalButton();
    }

//    @Test
//    public void testCartComponentHiddenOnCart() {
//        WebElement webElement = new CartPage(driver).getRootTotalButton();
//        Assert.assertTrue(webElement.);
//    }

//    @Test
//    public void testCartComponentVisibleOnCart() {
//        var menu = new MenuPage(driver).clickDrink(DrinkEnum.getName(DrinkEnum.CAFE_BREVE))
//                .getButtonElement().hoverTotalButton();
//    }
}
