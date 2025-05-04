package com.coffeecart.ui.VerifyTranslationToChinese;

import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

public class VerifyTranslationToChineseTest extends BaseTestRunner {

    @Test
    public void testDrinkNameTranslationOnDoubleClick() {
        Map<String, String> drinkTranslations = new HashMap<>();
        drinkTranslations.put("Espresso", "特浓咖啡");
        drinkTranslations.put("Espresso Macchiato", "浓缩玛奇朵");
        drinkTranslations.put("Cappuccino", "卡布奇诺");
        drinkTranslations.put("Mocha", "摩卡");
        drinkTranslations.put("Flat White", "平白咖啡");
        drinkTranslations.put("Americano", "美式咖啡");
        drinkTranslations.put("Cafe Latte", "拿铁");
        drinkTranslations.put("Espresso Con Panna", "浓缩康宝蓝");
        drinkTranslations.put("Cafe Breve", "半拿铁");

        SoftAssert softAssert = new SoftAssert();

        drinkTranslations.forEach((originalName, expectedTranslation) -> {
            WebElement drinkCardElement = driver.findElement(By.xpath("//h4[normalize-space(text())='" + originalName + "']/.."));
            CardComponent card = new CardComponent(driver, drinkCardElement);

            card.clickOnName();
            card.clickOnName();

            String actualTranslation = card.getCupAriaLabel();

            softAssert.assertEquals(actualTranslation, expectedTranslation,
                    String.format("The translation for '%s' is incorrect", originalName));
        });

        softAssert.assertAll();
    }
}