package com.coffeecart.ui;

import com.coffeecart.data.DrinkEnum;
import com.coffeecart.ui.component.LuckyDayComponent;
import com.coffeecart.ui.page.MenuPage;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

public class TestPossibilityAddingMocca extends BaseTestRunner {

    @DataProvider(name = "drinkNames")
    public Object[][] provideDrinkNames() {
        return Arrays.stream(DrinkEnum.values())
                .map(drinkEnum -> new Object[]{DrinkEnum.getName(drinkEnum)})
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "drinkNames")
    public void possibilityAddingMocca(String drinkName){
        SoftAssert softAssert = new SoftAssert();

        MenuPage menuPage = new MenuPage(driver);
        for (WebElement card: menuPage.getRootCards()){
            softAssert.assertTrue(card.isDisplayed(), String.format("The Card '%s' should be displayed",
                    card.getText()));
        }

        if(drinkName.equals(DrinkEnum.getName(DrinkEnum.ESPRESSO))){
            menuPage = menuPage.clickDrink(drinkName).clickDrink(drinkName).clickDrink(drinkName);
        }else{
            menuPage = menuPage.clickDrink(drinkName).clickDrink(drinkName);
        }

        LuckyDayComponent luckyDayComponent = menuPage.getGetLackyDayComponent();
        softAssert.assertTrue(menuPage.getLuckyDayModalRoot().isDisplayed(),
                "The LuckyDayModal should be displayed.");

        String expectedTitleLuckyDayComponent = "It's your lucky day! Get an extra cup of Mocha for $4.";
        softAssert.assertEquals(luckyDayComponent.getTitle(), expectedTitleLuckyDayComponent,
                String.format("The title of LuckyDayComponent should be '%s' but was '%s'",
                        expectedTitleLuckyDayComponent,
                        luckyDayComponent.getTitle()));

        int numberItemsInCart = menuPage.getHeader().getTotalNumberItemsFromCartLink();
        menuPage = luckyDayComponent.clickYes();
        softAssert.assertTrue(menuPage.isLuckyModalNotDisplayed(), "The LuckyDayModal shouldn't be displayed.");

        int expectedNumberItemsInCart = numberItemsInCart+1;
        int actualNumberItemsInCart = menuPage.getHeader().getTotalNumberItemsFromCartLink();
        softAssert.assertEquals(actualNumberItemsInCart, expectedNumberItemsInCart,
                String.format("The number of elements in Cart should be '%s' but was '%s'",
                        expectedNumberItemsInCart,
                        actualNumberItemsInCart));
    }
}
