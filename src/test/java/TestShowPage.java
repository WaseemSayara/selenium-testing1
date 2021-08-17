package test.java;

import main.java.ShowPage;
import main.resources.XPaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestShowPage {

    ShowPage showPage;

    @BeforeClass
    public void TestShowPageSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.showPage = new ShowPage(driver);
        this.showPage.goToURL(XPaths.signInPageURL);
        this.showPage.getDriver().findElement(XPaths.emailField).sendKeys(XPaths.myEmail);
        this.showPage.getDriver().findElement(XPaths.passwordField).sendKeys(XPaths.myPassword);
        this.showPage.getDriver().findElement(XPaths.signInButton).click();
        this.showPage.getDriver().findElement(XPaths.navBarAddresses).click();
        new WebDriverWait(this.showPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(XPaths.addressesShowButton));
        this.showPage.getDriver().findElement(XPaths.addressesShowButton).click();
        new WebDriverWait(this.showPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(XPaths.birthday));
    }

    @AfterMethod
    public void testTeardown() {
        this.showPage.goToURL(XPaths.showPageURL);
        new WebDriverWait(this.showPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(XPaths.birthday));
    }

    @AfterClass
    public void suiteTeardown() {
        this.showPage.closeDriver();
    }

    @Test
    public void testPageTitle() {
        Assert.assertEquals(this.showPage.getPageTitle(), "Address Book");
    }

    @Test
    public void testPageURL() {
        Assert.assertEquals(this.showPage.getURL(), XPaths.showPageURL);
    }

    @Test
    public void testSecAddress(){
        List<WebElement> secAddress= this.showPage.getSecAddress();
        Assert.assertEquals(secAddress.get(0).getText(), "Secondary Address:");
        Assert.assertEquals(secAddress.get(1).getText(), "palestine");
    }

    @Test
    public void testBirthday(){
        List<WebElement> birthday= this.showPage.getBirthday();
        Assert.assertEquals(birthday.get(0).getText(), "Birthday:");
        Assert.assertEquals(birthday.get(1).getText(), "8/25/2021");
    }
}
