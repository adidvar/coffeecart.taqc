package com.coffeecart.ui.page;

import com.coffeecart.ui.component.FullItemComponent;
import com.coffeecart.ui.component.TotalButtonElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartPage extends BasePage{
    @Getter
    private final List<FullItemComponent> fullItems = new ArrayList<>();

    @Getter
    private TotalButtonElement totalButton;

    @Getter
    @FindBy(xpath="//li[@class='list-header']/following::li[@class='list-item']")
    private List<WebElement> rootFullItems;

    @Getter
    @FindBy(xpath="//div[@class='pay-container']/button[contains(.,'Total:')]")
    private WebElement rootTotalButton;

    @Getter
    @FindBy(xpath="//div[@class='list']/p[contains(text(),'No coffee, go add some.')]")
    private WebElement emptyCartMessage;

    public CartPage(WebDriver driver) {
        super(driver);
        if(!emptyCartMessage.isDisplayed()) {
            totalButton = new TotalButtonElement(driver, rootTotalButton);
            for(WebElement fullItem: rootFullItems){
                fullItems.add(new FullItemComponent(driver, fullItem));
            }
        }
    }

//    @Step("Click on the Total button")
//    public PaymentDetailModal clickOnTotalButton(){
//        return totalButton.click();
//    }

    @Step("Clean the cart")
    public CartPage cleanCart(){
       for(FullItemComponent fullItem: fullItems){
            fullItem.clickOnDeleteButton();
       }
        return this;
    }

    @Step("Remove the item from the cart")
    public CartPage removeItemFromCart(String itemName){
        FullItemComponent fullItem = getFullItemByName(itemName);
        return fullItem.clickOnDeleteButton();
    }

    @Step("Increase number of items")
    public CartPage increaseNumberOfItems(String itemName){
        FullItemComponent fullItem = getFullItemByName(itemName);
        return fullItem.clickOnPlusButton();
    }

    @Step("Decrease number of items")
    public CartPage decreaseNumberOfItems(String itemName){
        FullItemComponent fullItem = getFullItemByName(itemName);
        return fullItem.clickOnMinusButton();
    }

    public FullItemComponent getFullItemByName(String itemName){
        Optional<FullItemComponent> component = fullItems.stream().filter(item -> item.getName().getText().equals(itemName)).findAny();
        if (component.isPresent()) {
            return component.get();
        }else{
            throw new RuntimeException("No component found");
        }
    }

    public int getTotalNumberOfItemsFromCart(){
        return fullItems.stream()
                .mapToInt(item -> {
                    Matcher match = Pattern.compile("(\\d+)$").matcher(item.getUnit());
                    if (match.find()) {
                        return Integer.parseInt(match.group());
                    }else{return 0;}
                }).sum();
    }

    public double getTotalPriceFromCart(){
        return fullItems.stream()
                .mapToDouble(item -> {
                    Matcher match = Pattern.compile("\\d+\\.\\d+").matcher(item.getTotal());
                    if (match.find()) {
                        return Double.parseDouble(match.group());
                    }else{return 0;}
                }).sum();
    }

    @Step("Navigate to the Menu Page")
    public MenuPage goToMenuPage(){
        header.navigateToMenu();
        return new MenuPage(driver);
    }

    @Step("Navigate to the GitHub Page")
    public GitHubPage goToGitHubPage(){
        header.navigateToGitHub();
        return new GitHubPage(driver);
    }
}
