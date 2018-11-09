import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class HomeWork3 {
    // Announcement of constants
    private final String HOME_PAGE = "http://automationpractice.com";
    private final By ARTICLE_MENU_WOMEN = By.xpath(".//a[@class = 'sf-with-ul']");
    private final By ARTICLE_MENU_DRESSES = By.xpath(".//div[@class = 'block_content']/ul/li/a");
    private final By ARTICLE_COLOR = By.xpath(".//ul[@class = 'col-lg-12 layered_filter_ul color-group']/li");

    private WebDriver browser;

    @Test
    public void choiceOfElements() {
        //Create WebDriver
        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        //Open browser
        browser = new FirefoxDriver();
        //Change window size
        browser.manage().window().maximize();
        //Go to home page
        browser.get(HOME_PAGE);

        Assertions.assertNotNull(getMenuItemByNameWomen("WOMEN"), "There is no such item in menu");
        getMenuItemByNameWomen("WOMEN").click();
        Assertions.assertNotNull(getMenuItemByNameDresses("Dresses"), "There is no such item in menu");
        getMenuItemByNameDresses("Dresses").click();
        Assertions.assertNotNull(getColor("Orange"), "There is no such item in menu");
        getColor("Orange").click();
    }

    private WebElement getColor(String name) {
        List<WebElement> elementsColor = browser.findElements(ARTICLE_COLOR);
        for (WebElement we : elementsColor) {
            if (we.getText().equals(name)) {
                return we;
            }
        }
        return null;
    }

    private WebElement getMenuItemByNameDresses(String name) {
        List<WebElement> menuElementsDresses = browser.findElements(ARTICLE_MENU_DRESSES);

        for (WebElement we : menuElementsDresses) {
            if (we.getText().equals(name)) {
                return we;
            }
        }

        return null;
    }

    private WebElement getMenuItemByNameWomen(String name) {
        List<WebElement> menuElementsWomen = browser.findElements(ARTICLE_MENU_WOMEN);

        for (WebElement we : menuElementsWomen) {
            if (we.getText().equals(name)) {
                return we;
            }
        }

        return null;
    }
}
