package com.coffeecart.ui.page;

import com.coffeecart.ui.component.CardComponent;
import com.coffeecart.ui.component.TotalButtonElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartPage extends BasePage{
//    @Getter
//    private List<FullItemComponent> fullItems = new ArrayList<>();

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

    @Getter
    @FindBy(xpath="//div[@class='modal']/div[@class='modal-content size']")
    private WebElement rootPaymentDetailModal;

    public CartPage(WebDriver driver) {
        super(driver);
        if(!emptyCartMessage.isDisplayed()) {
            totalButton = new TotalButtonElement(driver, rootTotalButton);
//        for(WebElement fullItem: rootFullItems){
//            fullItems.add(new FullItemComponent())
//        }
        }
    }

    @Step("Navigate to the Menu Page")
    public MenuPO goToMenuPage(){
//        header.clickMenuLink();
        return new MenuPO(driver);
    }

    @Step("Navigate to the GitHub Page")
    public GitHubPage goToGitHubPage(){
//        header.clickGitHubLink();
        return new GitHubPage(driver);
    }

//    @Step("Click on the Total button")
//    public PaymentDetailModal clickOnTotalButton(){
//        totalButton.click();
//        return new PaymentDetailModal(driver, rootPaymentDetailModal);
//    }

    @Step("Clean the cart")
    public CartPage cleanCart(){
//       for(WebElement fullItem: fullItems){
//            fullItem.clickOnDeleteButton();
//       }
        return new CartPage(driver);
    }

    @Step("Remove the item from the cart")
    public CartPage removeItemFromCart(String itemName){
//        FullItemComponent fullItem = getFullItemByName(itemName);
//        fullItem.clickOnDeleteButton();
        return new CartPage(driver);
    }

    @Step("Increase number of items")
    public CartPage increaseNumberOfItems(String itemName){
//        FullItemComponent fullItem = getFullItemByName(itemName);
//        fullItem.clickOnPlusButton()
        return new CartPage(driver);
    }

    @Step("Decrease number of items")
    public CartPage decreaseNumberOfItems(String itemName){
//        FullItemComponent fullItem = getFullItemByName(itemName);
//        fullItem.clickOnPlusButton()
        return new CartPage(driver);
    }

//    public FullItemComponent getFullItemByName(String itemName){
//        Optional<FullItemComponent> component = list.stream().filter(item -> item.getName().equals(itemName)).findAny();
//        FullItemComponent foundComponent;
//        if (component.isPresent()) {
//            return component.get();
//        }else{
//            throw new RuntimeException("No component found");
//        }
//    }

}
