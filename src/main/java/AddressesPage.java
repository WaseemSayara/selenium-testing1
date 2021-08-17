package main.java;

import main.resources.XPaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class AddressesPage {

    ChromeDriver driver;

    public AddressesPage(ChromeDriver driver) {
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

    public String getHeader2Text() {
        return driver.findElement(XPaths.header2).getText().trim();
    }

    public List<WebElement> getTableHeaders() {
        return driver.findElements(XPaths.addressesTableHeaders);
    }

    public List<WebElement> getTableFirstRow() {
        return driver.findElements(XPaths.addressesTableFirstRow);
    }

    public String getShowButtonText() {
        return driver.findElement(XPaths.addressesShowButton).getText().trim();
    }

    public void clickShowButton() {
        driver.findElement(XPaths.addressesShowButton).click();
    }

    public String getEditButtonText() {
        return driver.findElement(XPaths.addressesEditButton).getText().trim();
    }

    public void clickEditButton() {
        driver.findElement(XPaths.addressesEditButton).click();
    }

    public String getAddButtonText() {
        return driver.findElement(XPaths.addressesAddButton).getText().trim();
    }

    public void clickAddButton() {
        driver.findElement(XPaths.addressesAddButton).click();
    }

}
