package test.java;

import main.java.WelcomePage;
import main.resources.XPaths;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestWelcomePage {

    WelcomePage welcomePage;

    @BeforeClass
    public void TestHomePageSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.welcomePage = new WelcomePage(driver);
        this.welcomePage.goToURL(XPaths.welcomePageURL);
        new WebDriverWait(this.welcomePage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(XPaths.header1));
    }

    @AfterMethod
    public void testTeardown() {
        this.welcomePage.getDriver().manage().deleteAllCookies();
        this.welcomePage.goToURL(XPaths.welcomePageURL);
        new WebDriverWait(this.welcomePage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(XPaths.header1));
    }

    @AfterClass
    public void suiteTeardown() {
        this.welcomePage.closeDriver();
    }

    @Test
    public void testPageTitle() {
        Assert.assertEquals(this.welcomePage.getPageTitle(), "Address Book");
    }

    @Test
    public void testPageBodyH1Text() {
        Assert.assertEquals(this.welcomePage.getHeader1Text(), "Welcome to Address Book");
    }

    @Test
    public void testPageBodyH4Text() {
        Assert.assertEquals(this.welcomePage.getHeader4Text(), "A simple web app for showing off your testing");
    }

    @Test
    public void testNavBarHomeText() {
        Assert.assertEquals(this.welcomePage.getNavBarHomeText(), "Home");
    }

    @Test
    public void testNavBarHomeClickTitle() {
        this.welcomePage.clickOnNavBarHome();
        Assert.assertEquals(this.welcomePage.getPageTitle(), "Address Book");
    }

    @Test
    public void testNavBarHomeClickURL() {
        this.welcomePage.clickOnNavBarHome();
        Assert.assertEquals(this.welcomePage.getURL(), "http://a.testaddressbook.com/");
    }

    @Test
    public void testNavBarSignInText() {
        Assert.assertEquals(this.welcomePage.getNavBarSignInText(), "Sign in");
    }

    @Test
    public void testNavBarSignInClickTitle() {
        this.welcomePage.clickOnNavBarSignIn();
        new WebDriverWait(this.welcomePage.getDriver(), 5).until(ExpectedConditions.titleIs("Address Book - Sign In"));
        Assert.assertEquals(this.welcomePage.getPageTitle(), "Address Book - Sign In");
    }

    @Test
    public void testNavBarSignInClickURL() {
        this.welcomePage.clickOnNavBarSignIn();
        Assert.assertEquals(this.welcomePage.getURL(), "http://a.testaddressbook.com/sign_in");
    }

    @Test
    public void testNavBarSignInClickCurrent() {
        this.welcomePage.clickOnNavBarSignIn();
        Assert.assertTrue(this.welcomePage.getDriver().findElement(XPaths.navSignInCurrent).isDisplayed());
    }
}
