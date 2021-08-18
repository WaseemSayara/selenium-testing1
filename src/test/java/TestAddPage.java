package test.java;

import main.java.AddPage;
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


public class TestAddPage {

    AddPage addPage;

    @BeforeClass
    public void TestAddPageSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.addPage = new AddPage(driver);
        this.addPage.goToURL(XPaths.signInPageURL);
        this.addPage.getDriver().findElement(XPaths.emailField).sendKeys(XPaths.myEmail);
        this.addPage.getDriver().findElement(XPaths.passwordField).sendKeys(XPaths.myPassword);
        this.addPage.getDriver().findElement(XPaths.signInButton).click();
        this.addPage.getDriver().findElement(XPaths.navBarAddresses).click();
        new WebDriverWait(this.addPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(XPaths.addressesShowButton));
        this.addPage.getDriver().findElement(XPaths.addressesAddButton).click();
        new WebDriverWait(this.addPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(XPaths.createNewAddressButton));
    }

    @AfterMethod
    public void testTeardown() {
        this.addPage.goToURL(XPaths.addPageURL);
        new WebDriverWait(this.addPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(XPaths.createNewAddressButton));
    }

    @AfterClass
    public void suiteTeardown() {
        this.addPage.closeDriver();
    }

    @Test
    public void testPageTitle() {
        Assert.assertEquals(this.addPage.getPageTitle(), "Address Book");
    }

    @Test
    public void testPageURL() {
        Assert.assertEquals(this.addPage.getURL(), XPaths.addPageURL);
    }

    @Test
    public void testAddNewAddress() {
        String firstName = "Anwar";
        String lastName = "Qarout";
        String address1 = "Ramallah";
        String city = "Jordan";
        String zipCode = "1579";
        this.addPage.setAddFirstName(firstName);
        this.addPage.setAddLastName(lastName);
        this.addPage.setAddAddress1(address1);
        this.addPage.setAddCity(city);
        this.addPage.setAddState();
        this.addPage.setAddZipCode(zipCode);
        this.addPage.clickUpdateButton();

        Assert.assertEquals(this.addPage.getAddedFirstName(), firstName);
        Assert.assertEquals(this.addPage.getAddedLastName(), lastName);
        Assert.assertEquals(this.addPage.getAddedAddress1(), address1);
        Assert.assertEquals(this.addPage.getAddedCity(), city);
        Assert.assertEquals(this.addPage.getAddedState(), "CA");
        Assert.assertEquals(this.addPage.getAddedZipCode(), zipCode);
    }

    @Test()
    public void testDeleteAddress() {
        this.addPage.goToURL(XPaths.addressesPageURL);
        this.addPage.clickDestroyButton();
        this.addPage.getDriver().switchTo().alert().accept();
        Assert.assertEquals(this.addPage.getDestroyNotice(), "Address was successfully destroyed.");
        try {
            this.addPage.getDriver().findElement(XPaths.addressesTableThirdRow);
        } catch (org.openqa.selenium.NotFoundException e) {
            System.out.println("deleted");
        }
    }

}
