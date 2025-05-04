package com.coffeecart.ui;

import com.coffeecart.dataprovider.CheckCupPriceCostAndIngredientsDataProvider;
import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.page.MenuPage;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import com.coffeecart.dataprovider.CheckCupPriceCostAndIngredientsDataProvider.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CupTitlePriceIngredientsTest extends BaseTestRunner {
    private SoftAssert softAssert = new SoftAssert();

    @Test(dataProvider = "checkCorrectCardPricesDataProvider", dataProviderClass = CheckCupPriceCostAndIngredientsDataProvider.class)
    public void checkCorrectCardPrices(String cartTitle, double expectedPrice){
        List<CardComponent> cards = new MenuPage(driver).getCards();
        boolean cardExists = cards.stream().anyMatch(s -> s.getName().equals(cartTitle));
        softAssert.assertTrue(cardExists, "There is no card with such title " + cartTitle);

        List<CardComponent> foundCards = cards.stream().filter(s -> s.getName().equals(cartTitle)).toList();
        softAssert.assertEquals(1, foundCards.size(), "There should be only one card with such title " + cartTitle);

        CardComponent neededCard = foundCards.getFirst();
        softAssert.assertEquals(expectedPrice, neededCard.getPrice(), "Price is not appropriate with title " + cartTitle);

        softAssert.assertAll();
    }
}
