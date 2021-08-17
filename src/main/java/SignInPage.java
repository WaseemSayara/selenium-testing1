package main.java;
import main.resources.XPaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SignInPage {

    ChromeDriver driver;

    public SignInPage(ChromeDriver driver){
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

    public WebElement getEmailField(){
        return driver.findElement(XPaths.emailField);
    }

    public String getEmailFieldPlaceholder(){
        return driver.findElement(XPaths.emailField).getAttribute("placeholder").trim();
    }

    public void setEmailField(String mail){
        WebElement email = driver.findElement(XPaths.emailField);
        email.clear();
        email.sendKeys(mail);
    }

    public WebElement getPasswordField(){
        return driver.findElement(XPaths.passwordField);
    }

    public String getPasswordFieldPlaceholder(){
        return driver.findElement(XPaths.passwordField).getAttribute("placeholder").trim();
    }

    public void setPasswordField(String pass){
        WebElement password = driver.findElement(XPaths.passwordField);
        password.clear();
        password.sendKeys(pass);
    }

    public String getSignInButtonText(){
        return driver.findElement(XPaths.signInButton).getAttribute("value").trim();
    }

    public void clickSignInButton(){
        driver.findElement(XPaths.signInButton).click();
    }

    public String getSignUpButtonText(){
        return driver.findElement(XPaths.signUpButton).getText().trim();
    }

    public void clickSignUpButton(){
        driver.findElement(XPaths.signUpButton).click();
    }

    public String getWarningText(){
        return driver.findElement(XPaths.warning).getText().trim();
    }

}
