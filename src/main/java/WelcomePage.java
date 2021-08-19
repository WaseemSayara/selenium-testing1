package main.java;

import main.resources.VariablesPaths;
import org.openqa.selenium.chrome.ChromeDriver;


public class WelcomePage extends AddressBook {

    ChromeDriver driver;

    public WelcomePage(ChromeDriver driver) {
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

    public String getNavBarSignInText() {
        return driver.findElement(VariablesPaths.NAV_SIGN_IN).getText().trim();
    }

    public void clickOnNavBarSignIn() {
        driver.findElement(VariablesPaths.NAV_SIGN_IN).click();
    }

}
