package main.java;

import main.resources.XPaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class EditPage {

    ChromeDriver driver;

    public EditPage(ChromeDriver driver) {
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

    public void setNewLastName(String newName) {
        driver.findElement(XPaths.lastNameField).clear();
        driver.findElement(XPaths.lastNameField).sendKeys(newName);
    }

    public List<WebElement> getNewLastName() {
        return driver.findElements(XPaths.newLastName);
    }

    public String getUpdateButtonText() {
        return driver.findElement(XPaths.updateButton).getAttribute("value").trim();
    }

    public void clickUpdateButton() {
        driver.findElement(XPaths.updateButton).click();
    }

}
