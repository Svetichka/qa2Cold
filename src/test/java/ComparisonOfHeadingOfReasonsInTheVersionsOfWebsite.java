import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class ComparisonOfHeadingOfReasonsInTheVersionsOfWebsite {
    private final By ARTICLE_TITLE = By.xpath(".//a[@class = 'text-mine-shaft']");
    private final String HOME_PAGE = "http://rus.delfi.lv";
    private final By ARTICLE_TITLE_MOBILE = By.xpath(".//a[@class ='md-scrollpos']");
    private final String HOME_PAGE_MOBILE = "http://m.rus.delfi.lv";
    private WebDriver browser;

    @Test
    public void checkTitles() {
        List<WebElement> webElements = new ArrayList<WebElement>();
        List<WebElement> mobileElements = new ArrayList<WebElement>();

        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        browser = new FirefoxDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE);

        webElements = browser.findElements(ARTICLE_TITLE);
        Assertions.assertFalse(webElements.isEmpty(), "There is no webElements");

        List<String> webArticles = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            webArticles.add(webElements.get(i).getText());
        }

        browser.get(HOME_PAGE_MOBILE);
        mobileElements = browser.findElements(ARTICLE_TITLE_MOBILE);
        Assertions.assertFalse(webElements.isEmpty(), "There is no mobileElements");

        List<String> mobArticles = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            mobArticles.add(mobileElements.get(i).getText());
        }

        for (int i = 0; i < 5; i++) {
            Assertions.assertEquals(webArticles.get(i), mobArticles.get(i), "Articles is not equals");
        }
    }

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }
}