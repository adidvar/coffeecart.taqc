package com.coffeecart.ui.page;

import com.coffeecart.ui.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GitHubPage extends Base {
    @FindBy(xpath = "//*[@class='container']//a[@href]")
    private List<WebElement> pageLinks;

    public GitHubPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getPageLinks() {
        waitUntilAllElementsVisible(pageLinks);
        return pageLinks.stream()
                .map(link -> link.getDomAttribute("href"))
                .toList();
    }
}
