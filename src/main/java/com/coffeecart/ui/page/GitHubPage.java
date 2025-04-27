package com.coffeecart.ui.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GitHubPage extends BasePage {
    @FindBy(xpath = "//*[@class='container']//a[@href]")
    private List<WebElement> pageLinks;

    public GitHubPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get page links")
    public List<String> getPageLinks() {
        waitUntilAllElementsVisible(pageLinks);
        return getPageLinksElements().stream()
                .map(link -> link.getDomAttribute("href"))
                .toList();
    }

    public List<WebElement> getPageLinksElements() {
        return List.copyOf(pageLinks);
    }

}
