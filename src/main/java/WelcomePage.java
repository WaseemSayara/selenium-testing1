package main.java;

import main.resources.XPaths;
import org.openqa.selenium.chrome.ChromeDriver;


public class WelcomePage {

    ChromeDriver driver;

    public WelcomePage(ChromeDriver driver){
        this.driver = driver;
    }

    public ChromeDriver getDriver(){
        return driver;
    }

    public void goToURL(String URL){
        driver.get(URL);
    }

    public void closeDriver(){
        driver.close();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public String getHeader1Text(){
        return driver.findElement(XPaths.header1).getText().trim();
    }

    public String getHeader4Text(){
        return driver.findElement(XPaths.header4).getText().trim();
    }

    public String getNavBarHomeText(){
        return driver.findElement(XPaths.navBarHome).getText().trim();
    }

    public void clickOnNavBarHome(){
        driver.findElement(XPaths.navBarHome).click();
    }

    public String getNavBarSignInText(){
        return driver.findElement(XPaths.navSignIn).getText().trim();
    }

    public void clickOnNavBarSignIn(){
        driver.findElement(XPaths.navSignIn).click();
    }

}
