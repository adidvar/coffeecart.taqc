package com.coffeecart.ui.component;

import lombok.Getter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HeaderComponent extends BaseComponent {
    @FindBy(xpath = "//a[@aria-label='Menu page']")
    private WebElement menuLink;

    @FindBy(xpath = "//a[@aria-label='Cart page']")
    private WebElement cartLink;

    @FindBy(xpath = "//a[@aria-label='GitHub page']")
    private WebElement githubLink;

    public HeaderComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    @Step("Click on Cart page")
    public CartPage navigateToCart() {
        waitUntilElementClickable(cartLink);
        cartLink.click();
        return new CartPage(driver);
    }

}
