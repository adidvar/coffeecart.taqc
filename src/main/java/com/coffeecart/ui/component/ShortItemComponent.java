package com.coffeecart.ui.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShortItemComponent extends BaseComponent{

    @FindBy(xpath = "./div[1]/span[1]")
    WebElement spanName;
    @FindBy(xpath = "./div[1]/span[2]")
    WebElement spanCount;

    @FindBy(xpath = "./div[2]/button[1]")
    WebElement buttonMinus;
    @FindBy(xpath = "./div[2]/button[2]")
    WebElement buttonPlus;

    public ShortItemComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public String getName(){
        return spanName.getText();
    }

    public int getCount(){
        return Integer.parseInt(spanCount.getText().replace(" x ",""));
    }

    public ShortItemComponent clickPlus(){
        buttonPlus.click();
        return this;
    }

    public ShortItemComponent clickMinus(){
        buttonMinus.click();
        return this;
    }


}
