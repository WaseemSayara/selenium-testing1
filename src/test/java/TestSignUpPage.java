package test.java;

import main.java.SignUpPage;
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

import java.util.Date;


public class TestSignUpPage {

    SignUpPage signUpPage;

    @BeforeClass
    public void TestSignUpPageSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.signUpPage = new SignUpPage(driver);
        this.signUpPage.goToURL(VariablesPaths.SIGN_UP_PAGE_URL);
        new WebDriverWait(this.signUpPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.SIGN_UP_EMAIL_FIELD));
    }

    @AfterMethod
    public void testTeardown() {
        this.signUpPage.getDriver().manage().deleteAllCookies();
        this.signUpPage.goToURL(VariablesPaths.SIGN_UP_PAGE_URL);
        new WebDriverWait(this.signUpPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.SIGN_UP_EMAIL_FIELD));
    }

    @AfterClass
    public void suiteTeardown() {
        this.signUpPage.closeDriver();
    }

    @Test
    public void testPageTitle() {
        Assert.assertEquals(this.signUpPage.getPageTitle(), "Address Book - Sign Up");
    }


    @Test
    public void testEmailFieldPlaceholder() {
        Assert.assertEquals(this.signUpPage.getEmailFieldPlaceholder(), "Email");
    }

    @Test
    public void testPasswordFieldPlaceholder() {
        Assert.assertEquals(this.signUpPage.getPasswordFieldPlaceholder(), "Password");
    }

    @Test
    public void testSuccessSignUp() {
        long x = new Date().getTime();
        String newEmail = "was" + x + "@gmail.com";
        String newPassword = "124578";
        this.signUpPage.setEmailField(newEmail);
        this.signUpPage.setPasswordField(newPassword);
        this.signUpPage.clickSignUpButton();
        Assert.assertEquals(this.signUpPage.getURL(), VariablesPaths.HOME_PAGE_URL);
    }

    @Test
    public void testFailedSignUp() {
        this.signUpPage.setEmailField("was@gmail.com");
        this.signUpPage.setPasswordField("1212");
        this.signUpPage.clickSignUpButton();
        Assert.assertEquals(this.signUpPage.getURL(), VariablesPaths.USERS_PAGE_URL);
    }

}
