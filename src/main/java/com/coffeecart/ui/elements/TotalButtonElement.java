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

    PaymentDetail paymentDetail;

    CartComponent cartComponent ;

    Actions actions;

    public TotalButtonElement(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        paymentDetail = new PaymentDetail(driver, rootElement); // maybe use / as root element here
        cartComponent = new CartComponent(driver, rootElement);
        actions = new Actions(driver);
    }

    public PaymentDetail click(){
        totalButton.click();
        return paymentDetail;
    }

    public double getMoneyCounter() {
        return Double.parseDouble(totalButton.getText().replace("Total: $",""));
    }

    public CartComponent hover(){
        actions.moveToElement(totalButton).perform();
        return cartComponent;
    }
}
