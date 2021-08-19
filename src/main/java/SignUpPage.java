package main.java;

import main.resources.VariablesPaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SignUpPage extends AddressBook {

    ChromeDriver driver;

    public SignUpPage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getEmailFieldPlaceholder() {
        return driver.findElement(VariablesPaths.SIGN_UP_EMAIL_FIELD).getAttribute("placeholder").trim();
    }

    public void setEmailField(String mail) {
        WebElement email = driver.findElement(VariablesPaths.SIGN_UP_EMAIL_FIELD);
        email.clear();
        email.sendKeys(mail);
    }

    public String getPasswordFieldPlaceholder() {
        return driver.findElement(VariablesPaths.SIGN_UP_PASSWORD_FIELD).getAttribute("placeholder").trim();
    }

    public void setPasswordField(String pass) {
        WebElement password = driver.findElement(VariablesPaths.SIGN_UP_PASSWORD_FIELD);
        password.clear();
        password.sendKeys(pass);
    }

    public void clickSignUpButton() {
        driver.findElement(VariablesPaths.SIGN_UP_CONFIRM).click();
    }

}
