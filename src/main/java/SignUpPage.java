package main.java;

import main.resources.XPaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SignUpPage {

    ChromeDriver driver;

    public SignUpPage(ChromeDriver driver) {
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

    public String getEmailFieldPlaceholder() {
        return driver.findElement(XPaths.signUpEmailField).getAttribute("placeholder").trim();
    }

    public void setEmailField(String mail) {
        WebElement email = driver.findElement(XPaths.signUpEmailField);
        email.clear();
        email.sendKeys(mail);
    }

    public String getPasswordFieldPlaceholder() {
        return driver.findElement(XPaths.signUpPasswordField).getAttribute("placeholder").trim();
    }

    public void setPasswordField(String pass) {
        WebElement password = driver.findElement(XPaths.signUpPasswordField);
        password.clear();
        password.sendKeys(pass);
    }

    public void clickSignUpButton() {
        driver.findElement(XPaths.signUpConfirm).click();
    }

}
