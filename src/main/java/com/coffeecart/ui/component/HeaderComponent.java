package com.coffeecart.ui.component;

import com.coffeecart.ui.page.CartPage;
import com.coffeecart.ui.page.GitHubPage;
import com.coffeecart.ui.page.MenuPage;
import lombok.Getter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HeaderComponent extends BaseComponent {
    @Getter
    @FindBy(xpath = "//a[@aria-label='Menu page']")
    private WebElement menuLink;

    @Getter
    @FindBy(xpath = "//a[@aria-label='Cart page']")
    private WebElement cartLink;

    @Getter
    @FindBy(xpath = "//a[@aria-label='GitHub page']")
    private WebElement githubLink;

    public HeaderComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    @Step("Click on Menu page")
    public MenuPage navigateToMenu() {
        waitUntilElementClickable(menuLink);
        menuLink.click();
        return new MenuPage(driver);
    }

    @Step("Click on Cart page")
    public CartPage navigateToCart() {
        waitUntilElementClickable(cartLink);
        cartLink.click();
        return new CartPage(driver);
    }

    @Step("Click on GitHub page")
    public GitHubPage navigateToGitHub() {
        waitUntilElementClickable(githubLink);
        githubLink.click();
        return new GitHubPage(driver);
    }

}
