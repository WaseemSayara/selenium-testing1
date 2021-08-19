package test.java;

import main.java.ShowPage;
import main.resources.VariablesPaths;
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
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.showPage = new ShowPage(driver);
        this.showPage.goToURL(VariablesPaths.SIGN_IN_PAGE_URL);
        this.showPage.getDriver().findElement(VariablesPaths.EMAIL_FIELD).sendKeys(VariablesPaths.MY_EMAIL);
        this.showPage.getDriver().findElement(VariablesPaths.PASSWORD_FIELD).sendKeys(VariablesPaths.MY_PASSWORD);
        this.showPage.getDriver().findElement(VariablesPaths.SIGN_IN_BUTTON).click();
        this.showPage.getDriver().findElement(VariablesPaths.NAV_BAR_ADDRESSES).click();
        new WebDriverWait(this.showPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.ADDRESSES_SHOW_BUTTON));
        this.showPage.getDriver().findElement(VariablesPaths.ADDRESSES_SHOW_BUTTON).click();
        new WebDriverWait(this.showPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.BIRTHDAY));
    }

    @AfterMethod
    public void testTeardown() {
        this.showPage.goToURL(VariablesPaths.SHOW_PAGE_URL);
        new WebDriverWait(this.showPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.BIRTHDAY));
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
        Assert.assertEquals(this.showPage.getURL(), VariablesPaths.SHOW_PAGE_URL);
    }

    @Test
    public void testSecAddress() {
        List<WebElement> secAddress = this.showPage.getSecAddress();
        Assert.assertEquals(secAddress.get(0).getText(), "Secondary Address:");
        Assert.assertEquals(secAddress.get(1).getText(), "palestine");
    }

    @Test
    public void testBirthday() {
        List<WebElement> birthday = this.showPage.getBirthday();
        Assert.assertEquals(birthday.get(0).getText(), "Birthday:");
        Assert.assertEquals(birthday.get(1).getText(), "8/25/2021");
    }
}
