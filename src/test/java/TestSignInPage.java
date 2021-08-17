package test.java;

import main.java.SignInPage;
import main.resources.XPaths;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestSignInPage {

    SignInPage signInPage;

    @BeforeClass
    public void TestSignInPageSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.signInPage = new SignInPage(driver);
        this.signInPage.goToURL(XPaths.signInPageURL);
        new WebDriverWait(this.signInPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(XPaths.emailField));
    }

    @AfterMethod
    public void testTeardown() {
        this.signInPage.getDriver().manage().deleteAllCookies();
        this.signInPage.goToURL(XPaths.signInPageURL);
        new WebDriverWait(this.signInPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(XPaths.emailField));
    }

    @AfterClass
    public void suiteTeardown() {
        this.signInPage.closeDriver();
    }

    @Test
    public void testPageTitle() {
        Assert.assertEquals(this.signInPage.getPageTitle(), "Address Book - Sign In");
    }

    @Test
    public void testEmailField() {
        Assert.assertTrue(this.signInPage.getEmailField().isDisplayed());
    }

    @Test
    public void testEmailFieldPlaceholder() {
        Assert.assertEquals(this.signInPage.getEmailFieldPlaceholder(), "Email");
    }

    @Test
    public void testPasswordField() {
        Assert.assertTrue(this.signInPage.getPasswordField().isDisplayed());
    }

    @Test
    public void testPasswordFieldPlaceholder() {
        Assert.assertEquals(this.signInPage.getPasswordFieldPlaceholder(), "Password");
    }


    @Test
    public void testSignInButtonText() {
        Assert.assertEquals(this.signInPage.getSignInButtonText(), "Sign in");
    }

    @Test
    public void testSignUpButtonText() {
        Assert.assertEquals(this.signInPage.getSignUpButtonText(), "Sign up");
    }

    @Test
    public void testSuccessSignIn() {
        this.signInPage.setEmailField(XPaths.myEmail);
        this.signInPage.setPasswordField(XPaths.myPassword);
        this.signInPage.clickSignInButton();
        Assert.assertEquals(this.signInPage.getURL(), "http://a.testaddressbook.com/");
    }

    @Test
    public void testWrongEmailFormat() {
        this.signInPage.setEmailField("wrongemailformat");
        this.signInPage.setPasswordField(XPaths.myPassword);
        this.signInPage.clickSignInButton();
        Assert.assertEquals(this.signInPage.getURL(), XPaths.signInPageURL);
    }

    @Test
    public void testWrongEmail() {
        this.signInPage.setEmailField("wrongemail@gmail.com");
        this.signInPage.setPasswordField(XPaths.myPassword);
        this.signInPage.clickSignInButton();
        Assert.assertEquals(this.signInPage.getURL(), "http://a.testaddressbook.com/session");
        Assert.assertEquals(this.signInPage.getWarningText(), "Bad email or password.");
    }

    @Test
    public void testWrongPassword() {
        this.signInPage.setEmailField(XPaths.myEmail);
        this.signInPage.setPasswordField("wrong password");
        this.signInPage.clickSignInButton();
        Assert.assertEquals(this.signInPage.getURL(), "http://a.testaddressbook.com/session");
        Assert.assertEquals(this.signInPage.getWarningText(), "Bad email or password.");
    }

    @Test
    public void testSignUpClick() {
        this.signInPage.clickSignUpButton();
        Assert.assertEquals(this.signInPage.getURL(), "http://a.testaddressbook.com/sign_up");
    }
}
