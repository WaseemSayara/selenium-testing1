package main.java;

import main.resources.XPaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class ShowPage {

    ChromeDriver driver;

    public ShowPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public ChromeDriver getDriver() {
        return driver;
    }

    public void goToURL(String URL) {
        driver.get(URL);
    }

    public void closeDriver() {
        driver.close();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public List<WebElement> getSecAddress() {
        return driver.findElements(XPaths.secondaryAddress);
    }

    public List<WebElement> getBirthday() {
        return driver.findElements(XPaths.birthday);
    }

}
