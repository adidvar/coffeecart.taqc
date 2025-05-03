package com.coffeecart.ui.elements;

import com.coffeecart.ui.component.CartComponent;
import com.coffeecart.ui.modal.PaymentDetailModal;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TotalButtonElement extends BaseElement {

    @Getter
    @FindBy(xpath = ".//button[@class='pay']")
    WebElement totalButton;

    @Getter
    @FindBy(xpath = ".//ul[@class='cart-preview']")
    WebElement cartComponentRoot;

    @Getter
    @FindBy(xpath = "//div[@class='modal']")
    WebElement modalElement;

    CartComponent cartComponent;

    Actions actions;

    public TotalButtonElement(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        cartComponent = new CartComponent(driver, cartComponentRoot);
        actions = new Actions(driver);
    }

    public PaymentDetailModal clickTotalButton(){
        waitUntilElementClickable(totalButton);
        totalButton.click();
        return new PaymentDetailModal(driver,modalElement);
    }

    public double getMoneyCounter() {
        return Double.parseDouble(totalButton.getText().replace("Total: $",""));
    }

    public CartComponent hoverTotalButton(){
        actions.moveToElement(totalButton).perform();
        waitUntilElementVisible(cartComponentRoot);
        return cartComponent;
    }
}
