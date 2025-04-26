package com.coffeecart.ui;

import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.component.HeaderComponent;
import com.coffeecart.ui.page.CartPage;
import com.coffeecart.ui.page.MenuPage;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class CartPageTest extends BaseTestRunner{
    @Test
    public void firstTest() {
        Assertion assertion = new Assertion();

        MenuPage page = new MenuPage(driver);
        HeaderComponent header = page.getHeader();
        WebElement cappuccinoCard = driver.findElement(
                By.xpath("//li[.//*[@data-test='Cappuccino']]"));
        for (int i = 0; i < 5; i++) {
            cappuccinoCard.click();
        }

        CartPage cartPage = header.navigateToCart();

        int itemsInCart = cartPage.getFullItems().size();

        assertion.assertEquals(itemsInCart, 1);

        assertion.assertEquals(header.getTotalNumberItemsFromCartLink(), 5);

        itemsInCart = cartPage.removeNumberOfItems("Cappuccino").getTotalNumberOfItemsFromCart();
        assertion.assertEquals(itemsInCart, 4);

        itemsInCart = cartPage.removeNumberOfItems("Cappuccino", 2).getTotalNumberOfItemsFromCart();
        assertion.assertEquals(itemsInCart, 2);

        itemsInCart = cartPage.increaseNumberOfItems("Cappuccino").getTotalNumberOfItemsFromCart();
        assertion.assertEquals(itemsInCart, 3);

        itemsInCart = cartPage.increaseNumberOfItems("Cappuccino", 2).getTotalNumberOfItemsFromCart();
        assertion.assertEquals(itemsInCart, 5);

        String message = cartPage.deleteItemFromCart("Cappuccino").getEmptyCartMessage().getText();
        assertion.assertEquals(message, "No coffee, go add some.");

        page = cartPage.goToMenuPage();
        cappuccinoCard = driver.findElement(
                By.xpath("//li[.//*[@data-test='Cappuccino']]"));
        WebElement espressoMacchiatoCard = driver.findElement(
                By.xpath("//li[.//*[@data-test='Espresso_Macchiato']]"));
        CardComponent cardComponentCappuccino = new CardComponent(driver, cappuccinoCard);
        CardComponent cardComponentEspressoMacchiato = new CardComponent(driver, espressoMacchiatoCard);

        double capuccinoPrice = cardComponentCappuccino.getPrice();
        double expressoMacchiatoPrice = cardComponentEspressoMacchiato.getPrice();
        espressoMacchiatoCard.click();
        cappuccinoCard.click();
        cappuccinoCard.click();
        cartPage = header.navigateToCart();

        assertion.assertEquals(cartPage.getSumOfPricesOfOneUnitFromCart(), capuccinoPrice + expressoMacchiatoPrice);

        double totalPrice = capuccinoPrice * 2 + expressoMacchiatoPrice;
        assertion.assertEquals(cartPage.getSumOfTotalPricesFromCart(), totalPrice);

        message = cartPage.cleanCart().getEmptyCartMessage().getText();
        assertion.assertEquals(message, "No coffee, go add some.");
    }

}
