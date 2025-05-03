package com.coffeecart.ui;

import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.page.MenuPage;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestPossibilityAddingMocca extends BaseTestRunner {
    @Test
    public void possibilityAddingMocca(){
        SoftAssert softAssert = new SoftAssert();

        MenuPage menuPage = new MenuPage(driver);
        for (WebElement card: menuPage.getRootCards()){
            softAssert.assertTrue(card.isDisplayed());
        }

        menuPage = menuPage.clickDrink("Espresso")
                .clickDrink("Espresso")
                .clickDrink("Espresso");

        softAssert.assertTrue(menuPage.getLuckyDayModalRoot().isDisplayed());




    }
}
