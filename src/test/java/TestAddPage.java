package test.java;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import main.java.AddPage;
import main.resources.VariablesPaths;
import org.openqa.selenium.By;
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

import java.io.FileReader;
import java.io.IOException;


public class TestAddPage {

    AddPage addPage;

    @BeforeClass
    public void TestAddPageSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.addPage = new AddPage(driver);
        this.addPage.goToURL(VariablesPaths.SIGN_IN_PAGE_URL);
        this.addPage.getDriver().findElement(VariablesPaths.EMAIL_FIELD).sendKeys(VariablesPaths.MY_EMAIL);
        this.addPage.getDriver().findElement(VariablesPaths.PASSWORD_FIELD).sendKeys(VariablesPaths.MY_PASSWORD);
        this.addPage.getDriver().findElement(VariablesPaths.SIGN_IN_BUTTON).click();
        this.addPage.getDriver().findElement(VariablesPaths.NAV_BAR_ADDRESSES).click();
        new WebDriverWait(this.addPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.ADDRESSES_SHOW_BUTTON));
        this.addPage.getDriver().findElement(VariablesPaths.ADDRESSES_ADD_BUTTON).click();
        new WebDriverWait(this.addPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.CREATE_NEW_ADDRESS_BUTTON));
    }

    @AfterMethod
    public void testTeardown() {
        this.addPage.goToURL(VariablesPaths.ADD_PAGE_URL);
        new WebDriverWait(this.addPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.CREATE_NEW_ADDRESS_BUTTON));
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
        Assert.assertEquals(this.addPage.getURL(), VariablesPaths.ADD_PAGE_URL);
    }

    @Test
    public void testAddNewAddress() throws IOException {

        FileReader filereader = new FileReader("src/main/resources/NewAddressesData.csv");
        CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
        String[] newAddressData = csvReader.readNext();

        String firstName = newAddressData[0];
        String lastName = newAddressData[1];
        String address1 = newAddressData[2];
        String city = newAddressData[3];
        String zipCode = newAddressData[4];

        this.addPage.setAddFirstName(firstName);
        this.addPage.setAddLastName(lastName);
        this.addPage.setAddAddress1(address1);
        this.addPage.setAddCity(city);
        this.addPage.setAddState();
        this.addPage.setAddZipCode(zipCode);
        this.addPage.clickUpdateButton();

        Assert.assertEquals(this.addPage.getAdditionConfirmText(), "Address was successfully created.");
        Assert.assertEquals(this.addPage.getAddedFirstName(), firstName);
        Assert.assertEquals(this.addPage.getAddedLastName(), lastName);
        Assert.assertEquals(this.addPage.getAddedAddress1(), address1);
        Assert.assertEquals(this.addPage.getAddedCity(), city);
        Assert.assertEquals(this.addPage.getAddedState(), "CA");
        Assert.assertEquals(this.addPage.getAddedZipCode(), zipCode);

        this.addPage.clickListButton();

        String path = this.addPage.toDeletePathCreator(newAddressData, "CA");
        new WebDriverWait(this.addPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(path)));
        WebElement newRow = this.addPage.getDriver().findElement(By.xpath(path));

        Assert.assertNotNull(newRow);
    }

    @Test(priority = 9)
    public void testDeleteAddress() throws IOException {

        FileReader filereader = new FileReader("src/main/resources/NewAddressesData.csv");
        CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
        String[] newAddressData = csvReader.readNext();

        this.addPage.goToURL(VariablesPaths.ADDRESSES_PAGE_URL);

        String path = this.addPage.toDeletePathCreator(newAddressData, "CA");
        path += "/td/a[text()='Destroy']";
        this.addPage.clickDestroyButton(path);
        this.addPage.getDriver().switchTo().alert().accept();
        new WebDriverWait(this.addPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.ADDRESSES_DESTROY_NOTICE));
        Assert.assertEquals(this.addPage.getDestroyNotice(), "Address was successfully destroyed.");
        try {
            this.addPage.getDriver().findElement(By.xpath(path));
        } catch (org.openqa.selenium.NotFoundException e) {
            System.out.println("deleted");
        }

    }

}
