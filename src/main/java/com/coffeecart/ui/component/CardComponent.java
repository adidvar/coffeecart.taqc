package com.coffeecart.ui.component;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class CardComponent extends BaseComponent {
    @Getter
    @FindBy(xpath = ".//h4")
    private WebElement nameElement;
    @Getter
    @FindBy(xpath = ".//h4/small")
    private WebElement priceElement;
    @Getter
    @FindBy(xpath = ".//div[contains(@class, 'cup')]")
    private WebElement cupRootElement;
    @Getter
    @FindBy(xpath = ".//p[contains(@class, 'description')]")
    private WebElement descriptionElement;

    private CupComponent cupComponent;

    public CardComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        this.cupComponent = new CupComponent(driver, cupRootElement);
    }

    public String getName() {
        return nameElement.getText().split("\n")[0].trim();
    }

    public double getPrice() {
        String priceText = priceElement.getText().replace("$", "").trim();
        return Double.parseDouble(priceText);
    }
    public String getCupBorderColorOnHover() {
        Actions actions = new Actions(driver);
        actions.moveToElement(cupRootElement).perform();
        return cupRootElement.getCssValue("border-color");
    }

    public String getNameColorOnHover() {
        Actions actions = new Actions(driver);
        actions.moveToElement(nameElement).perform();
        return nameElement.getCssValue("color");
    }

    public String getDescription() {
        return descriptionElement.getText().trim();
    }

    public void clickOnCup() {
        cupRootElement.click();
    }

    public void clickOnName() {
        nameElement.click();
    }

    public String getNameFontSize() {
        return nameElement.getCssValue("font-size");
    }

    public String getCupBackgroundColor() {
        return cupRootElement.getCssValue("background-color");
    }

    public boolean isCupDisplayed() {
        return cupRootElement.isDisplayed();
    }

    public CupComponent getCupComponent() {
        return cupComponent;
    }
}

