package com.coffeecart.ui.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.function.Consumer;

public class GitHubPage extends BasePage {
    @FindBy(xpath = "//*[@class='container']//a[@href]")
    private List<WebElement> pageLinks;

    public GitHubPage(WebDriver driver) {
        super(driver);
    }

    @Step("Handle page links")
    public GitHubPage handlePageLinks(Consumer<List<String>> linksConsumer) {
        waitUntilAllElementsVisible(getPageLinksElements());
        List<String> links = getPageLinksElements().stream()
                .map(link -> link.getDomAttribute("href"))
                .toList();
        linksConsumer.accept(links);
        return this;
    }

    public List<WebElement> getPageLinksElements() {
        return List.copyOf(pageLinks);
    }

}
