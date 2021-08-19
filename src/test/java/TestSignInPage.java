package test.java;

import main.java.SignInPage;
import main.resources.VariablesPaths;
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
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.signInPage = new SignInPage(driver);
        this.signInPage.goToURL(VariablesPaths.SIGN_IN_PAGE_URL);
        new WebDriverWait(this.signInPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.EMAIL_FIELD));
    }

    @AfterMethod
    public void testTeardown() {
        this.signInPage.getDriver().manage().deleteAllCookies();
        this.signInPage.goToURL(VariablesPaths.SIGN_IN_PAGE_URL);
        new WebDriverWait(this.signInPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.EMAIL_FIELD));
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
        this.signInPage.setEmailField(VariablesPaths.MY_EMAIL);
        this.signInPage.setPasswordField(VariablesPaths.MY_PASSWORD);
        this.signInPage.clickSignInButton();
        Assert.assertEquals(this.signInPage.getURL(), VariablesPaths.HOME_PAGE_URL);
    }

    @Test
    public void testWrongEmailFormat() {
        this.signInPage.setEmailField("wrongemailformat");
        this.signInPage.setPasswordField(VariablesPaths.MY_PASSWORD);
        this.signInPage.clickSignInButton();
        Assert.assertEquals(this.signInPage.getURL(), VariablesPaths.SIGN_IN_PAGE_URL);
    }

    @Test
    public void testWrongEmail() {
        this.signInPage.setEmailField("wrongemail@gmail.com");
        this.signInPage.setPasswordField(VariablesPaths.MY_PASSWORD);
        this.signInPage.clickSignInButton();
        Assert.assertEquals(this.signInPage.getURL(), "http://a.testaddressbook.com/session");
        Assert.assertEquals(this.signInPage.getWarningText(), "Bad email or password.");
    }

    @Test
    public void testWrongPassword() {
        this.signInPage.setEmailField(VariablesPaths.MY_EMAIL);
        this.signInPage.setPasswordField("wrong password");
        this.signInPage.clickSignInButton();
        Assert.assertEquals(this.signInPage.getURL(), "http://a.testaddressbook.com/session");
        Assert.assertEquals(this.signInPage.getWarningText(), "Bad email or password.");
    }

    @Test
    public void testSignUpClick() {
        this.signInPage.clickSignUpButton();
        Assert.assertEquals(this.signInPage.getURL(), VariablesPaths.SIGN_UP_PAGE_URL);
    }
}
