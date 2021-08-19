package main.java;

import main.resources.VariablesPaths;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomePage extends AddressBook {

    ChromeDriver driver;

    public HomePage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getHeader1Text() {
        return driver.findElement(VariablesPaths.HEADER_1).getText().trim();
    }

    public String getHeader4Text() {
        return driver.findElement(VariablesPaths.HEADER_4).getText().trim();
    }

    public String getNavBarHomeText() {
        return driver.findElement(VariablesPaths.NAV_BAR_HOME).getText().trim();
    }

    public void clickOnNavBarHome() {
        driver.findElement(VariablesPaths.NAV_BAR_HOME).click();
    }

    public String getNavBarAddressesText() {
        return driver.findElement(VariablesPaths.NAV_BAR_ADDRESSES).getText().trim();
    }

    public void clickOnNavBarAddresses() {
        driver.findElement(VariablesPaths.NAV_BAR_ADDRESSES).click();
    }

    public String getNavBarSignOutText() {
        return driver.findElement(VariablesPaths.NAV_BAR_SIGN_OUT).getText().trim();
    }

    public void clickOnNavBarSignOut() {
        driver.findElement(VariablesPaths.NAV_BAR_SIGN_OUT).click();
    }

    public String getNavBarSignedInEmailText() {
        return driver.findElement(VariablesPaths.SIGNED_IN_EMAIL).getText().trim();
    }

}
