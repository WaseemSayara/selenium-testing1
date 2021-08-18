package test.java;

import main.java.AddressesPage;
import main.resources.XPaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class TestAddressesPage {

    AddressesPage addressesPage;

    @BeforeClass
    public void TestAddressesPageSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.addressesPage = new AddressesPage(driver);
        this.addressesPage.goToURL(XPaths.signInPageURL);
        this.addressesPage.getDriver().findElement(XPaths.emailField).sendKeys(XPaths.myEmail);
        this.addressesPage.getDriver().findElement(XPaths.passwordField).sendKeys(XPaths.myPassword);
        this.addressesPage.getDriver().findElement(XPaths.signInButton).click();
        this.addressesPage.getDriver().findElement(XPaths.navBarAddresses).click();
        new WebDriverWait(this.addressesPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(XPaths.addressesAddButton));
    }

    @AfterMethod
    public void testTeardown() {
        this.addressesPage.goToURL(XPaths.addressesPageURL);
        new WebDriverWait(this.addressesPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(XPaths.addressesAddButton));
    }

    @AfterClass
    public void suiteTeardown() {
        this.addressesPage.closeDriver();
    }

    @Test
    public void testPageTitle() {
        Assert.assertEquals(this.addressesPage.getPageTitle(), "Address Book");
    }


    @Test
    public void testPageURL() {
        Assert.assertEquals(this.addressesPage.getURL(), XPaths.addressesPageURL);
    }

    @Test
    public void testPageBodyH2Text() {
        Assert.assertEquals(this.addressesPage.getHeader2Text(), "Addresses");
    }

    @Test
    public void testTableHeaders() {
        List<WebElement> tableHeaders = this.addressesPage.getTableHeaders();
        Assert.assertEquals(tableHeaders.get(0).getText(), "First name");
        Assert.assertEquals(tableHeaders.get(1).getText(), "Last name");
        Assert.assertEquals(tableHeaders.get(2).getText(), "City");
        Assert.assertEquals(tableHeaders.get(3).getText(), "State");
    }

    @Test
    public void testFirstRow() {
        List<WebElement> firstRow = this.addressesPage.getTableFirstRow();
        Assert.assertEquals(firstRow.get(0).getText(), "waseem");
        Assert.assertEquals(firstRow.get(1).getText(), "sayara");
        Assert.assertEquals(firstRow.get(2).getText(), "ramallah");
        Assert.assertEquals(firstRow.get(3).getText(), "AL");
        Assert.assertEquals(firstRow.get(4).getText(), "Show");
        Assert.assertEquals(firstRow.get(5).getText(), "Edit");
        Assert.assertEquals(firstRow.get(6).getText(), "Destroy");
    }

    @Test
    public void testShowButtonText() {
        Assert.assertEquals(this.addressesPage.getShowButtonText(), "Show");
    }

    @Test
    public void testClickShowButtonURL() {
        this.addressesPage.clickShowButton();
        Assert.assertEquals(this.addressesPage.getURL(), XPaths.showPageURL);
    }

    @Test
    public void testEditButtonText() {
        Assert.assertEquals(this.addressesPage.getEditButtonText(), "Edit");
    }

    @Test
    public void testClickEditButtonURL() {
        this.addressesPage.clickEditButton();
        Assert.assertEquals(XPaths.editPageURL, this.addressesPage.getURL());
    }

    @Test
    public void testAddButtonText() {
        Assert.assertEquals(this.addressesPage.getAddButtonText(), "New Address");
    }

    @Test
    public void testClickAddButtonURL() {
        this.addressesPage.clickAddButton();
        Assert.assertEquals(this.addressesPage.getURL(), XPaths.addPageURL);
    }

}
