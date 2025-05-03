package com.coffeecart.ui.discardLuckyProposition;

import com.coffeecart.ui.component.ShortItemComponent;
import com.coffeecart.ui.page.MenuPage;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class DiscardLuckyPropositionTest extends BaseTestRunner {

    @Test
    public void testLuckyPropositionDiscard() {
        String flatWhite = "Flat White";
        String americano = "Americano";
        String espressoMacchiato = "Espresso Macchiato";
        String espresso = "Espresso";
        String discountedDrink = "Mocha";

        MenuPage menuPage = new MenuPage(driver);

        menuPage.clickDrink(flatWhite)
                .clickDrink(flatWhite)
                .clickDrink(flatWhite)
                .getGetLackyDayComponent().clickSkip()
                .getButtonElement()
                .hoverTotalButton()
                .getShortItems().stream()
                .filter(item -> item.getName().equals(flatWhite))
                .findFirst()
                .ifPresent(item -> item.clickMinus().clickMinus().clickMinus());

        menuPage.clickDrink(americano)
                .clickDrink(espressoMacchiato)
                .clickDrink(espresso)
                .getGetLackyDayComponent().clickSkip();

        List<String> expected = new ArrayList<>(List.of(americano, espressoMacchiato, espresso));
        List<String> actual = menuPage.getButtonElement()
                .hoverTotalButton()
                .getShortItems().stream()
                .map(ShortItemComponent::getName)
                .collect(Collectors.toList());

        Collections.sort(expected);
        Collections.sort(actual);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actual, expected, "Cart contains unexpected drinks");
        softAssert.assertFalse(actual.contains(discountedDrink), "Mocha should NOT be in the cart");

        softAssert.assertAll();
    }
}
