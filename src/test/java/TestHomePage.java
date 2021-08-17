package test.java;

import main.java.HomePage;
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


public class TestHomePage {

    HomePage homePage;

    @BeforeClass
    public void TestHomePageSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.homePage = new HomePage(driver);
        this.homePage.goToURL(XPaths.signInPageURL);
        this.homePage.getDriver().findElement(XPaths.emailField).sendKeys(XPaths.myEmail);
        this.homePage.getDriver().findElement(XPaths.passwordField).sendKeys(XPaths.myPassword);
        this.homePage.getDriver().findElement(XPaths.signInButton).click();
    }

    @AfterMethod
    public void testTeardown() {
        this.homePage.getDriver().manage().deleteAllCookies();
        this.homePage.goToURL(XPaths.homePageURL);
    }

    @AfterClass
    public void suiteTeardown() {
        this.homePage.closeDriver();
    }

    @Test
    public void testPageTitle() {
        Assert.assertEquals(this.homePage.getPageTitle(), "Address Book");
    }

    @Test
    public void testPageBodyH1Text() {
        Assert.assertEquals(this.homePage.getHeader1Text(), "Welcome to Address Book");
    }

    @Test
    public void testPageBodyH4Text() {
        Assert.assertEquals(this.homePage.getHeader4Text(), "A simple web app for showing off your testing");
    }

    @Test
    public void testNavBarHomeText() {
        Assert.assertEquals(this.homePage.getNavBarHomeText(), "Home");
    }

    @Test
    public void testNavBarHomeClickText() {
        this.homePage.clickOnNavBarHome();
        Assert.assertEquals(this.homePage.getPageTitle(), "Address Book");
    }

    @Test
    public void testNavBarHomeClickURL() {
        this.homePage.clickOnNavBarHome();
        Assert.assertEquals(this.homePage.getURL(), "http://a.testaddressbook.com/");
    }

    @Test
    public void testNavBarAddressesText() {
        new WebDriverWait(this.homePage.getDriver(), 5).until(ExpectedConditions.visibilityOf
                (this.homePage.getDriver().findElement(XPaths.navBarAddresses)));
        Assert.assertEquals(this.homePage.getNavBarAddressesText(), "Addresses");
    }

    @Test
    public void testNavBarAddressesClickTitle() {
        new WebDriverWait(this.homePage.getDriver(), 5).until(ExpectedConditions.visibilityOf
                (this.homePage.getDriver().findElement(XPaths.navBarAddresses)));
        this.homePage.clickOnNavBarAddresses();
        Assert.assertEquals(this.homePage.getPageTitle(), "Address Book");
    }

    @Test
    public void testNavBarAddressesClickURL() {
        new WebDriverWait(this.homePage.getDriver(), 5).until(ExpectedConditions.visibilityOf
                (this.homePage.getDriver().findElement(XPaths.navBarAddresses)));
        this.homePage.clickOnNavBarAddresses();
        Assert.assertEquals(this.homePage.getURL(), "http://a.testaddressbook.com/addresses");
    }

}
