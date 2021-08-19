package main.java;

import main.resources.VariablesPaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SignInPage extends AddressBook {

    ChromeDriver driver;

    public SignInPage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement getEmailField() {
        return driver.findElement(VariablesPaths.EMAIL_FIELD);
    }

    public String getEmailFieldPlaceholder() {
        return driver.findElement(VariablesPaths.EMAIL_FIELD).getAttribute("placeholder").trim();
    }

    public void setEmailField(String mail) {
        WebElement email = driver.findElement(VariablesPaths.EMAIL_FIELD);
        email.clear();
        email.sendKeys(mail);
    }

    public WebElement getPasswordField() {
        return driver.findElement(VariablesPaths.PASSWORD_FIELD);
    }

    public String getPasswordFieldPlaceholder() {
        return driver.findElement(VariablesPaths.PASSWORD_FIELD).getAttribute("placeholder").trim();
    }

    public void setPasswordField(String pass) {
        WebElement password = driver.findElement(VariablesPaths.PASSWORD_FIELD);
        password.clear();
        password.sendKeys(pass);
    }

    public String getSignInButtonText() {
        return driver.findElement(VariablesPaths.SIGN_IN_BUTTON).getAttribute("value").trim();
    }

    public void clickSignInButton() {
        driver.findElement(VariablesPaths.SIGN_IN_BUTTON).click();
    }

    public String getSignUpButtonText() {
        return driver.findElement(VariablesPaths.SIGN_UP_BUTTON).getText().trim();
    }

    public void clickSignUpButton() {
        driver.findElement(VariablesPaths.SIGN_UP_BUTTON).click();
    }

    public String getWarningText() {
        return driver.findElement(VariablesPaths.WARNING).getText().trim();
    }

}
