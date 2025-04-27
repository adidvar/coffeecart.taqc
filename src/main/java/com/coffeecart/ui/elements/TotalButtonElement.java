package com.coffeecart.ui.elements;

import com.coffeecart.ui.component.CartComponent;
import com.coffeecart.ui.modal.PaymentDetail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TotalButtonElement extends BaseElement {

    @FindBy(xpath = ".//button[@class='pay']")
    WebElement totalButton;

    @FindBy(xpath = ".//ul[@class='cart-preview']")
    WebElement cardComponentElement;

    @FindBy(xpath = "//div[@class='modal']")
    WebElement modalElement;

    CartComponent cartComponent;

    Actions actions;

    public TotalButtonElement(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        cartComponent = new CartComponent(driver, cardComponentElement);
        actions = new Actions(driver);
    }

    public PaymentDetail click(){
        totalButton.click();
        return new PaymentDetail(driver,modalElement);
    }

    public double getMoneyCounter() {
        return Double.parseDouble(totalButton.getText().replace("Total: $",""));
    }

    public CartComponent hover(){
        actions.moveToElement(totalButton).perform();
        return cartComponent;
    }
}
