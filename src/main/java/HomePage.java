package main.java;

import main.resources.XPaths;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomePage {

    ChromeDriver driver;

    public HomePage(ChromeDriver driver) {
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

    public String getHeader1Text() {
        return driver.findElement(XPaths.header1).getText().trim();
    }

    public String getHeader4Text() {
        return driver.findElement(XPaths.header4).getText().trim();
    }

    public String getNavBarHomeText() {
        return driver.findElement(XPaths.navBarHome).getText().trim();
    }

    public void clickOnNavBarHome() {
        driver.findElement(XPaths.navBarHome).click();
    }

    public String getNavBarAddressesText() {
        return driver.findElement(XPaths.navBarAddresses).getText().trim();
    }

    public void clickOnNavBarAddresses() {
        driver.findElement(XPaths.navBarAddresses).click();
    }

    public String getNavBarSignOutText() {
        return driver.findElement(XPaths.navBarSignOut).getText().trim();
    }

    public void clickOnNavBarSignOut() {
        driver.findElement(XPaths.navBarSignOut).click();
    }

    public String getNavBarSignedInEmailText() {
        return driver.findElement(XPaths.SignedInEmail).getText().trim();
    }

}
