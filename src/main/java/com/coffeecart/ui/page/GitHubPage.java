package com.coffeecart.ui.page;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.function.Consumer;

public class GitHubPage extends BasePage {
    @Getter
    @FindBy(xpath = "//*[@class='container']//a[@href]")
    private List<WebElement> pageLinks;

    public GitHubPage(WebDriver driver) {
        super(driver);
    }

    @Step("Handle page links")
    public GitHubPage handlePageLinks(Consumer<List<String>> linksConsumer) {
        waitUntilAllElementsVisible(getPageLinks());
        List<String> links = getPageLinks().stream()
                .map(link -> link.getDomAttribute("href"))
                .toList();
        linksConsumer.accept(links);
        return this;
    }

}
