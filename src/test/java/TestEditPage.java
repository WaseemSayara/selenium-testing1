package test.java;

import main.java.EditPage;
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
import java.util.Random;


public class TestEditPage {

    EditPage editPage;

    @BeforeClass
    public void TestEditPageSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.editPage = new EditPage(driver);
        this.editPage.goToURL(VariablesPaths.SIGN_IN_PAGE_URL);
        this.editPage.getDriver().findElement(VariablesPaths.EMAIL_FIELD).sendKeys(VariablesPaths.MY_EMAIL);
        this.editPage.getDriver().findElement(VariablesPaths.PASSWORD_FIELD).sendKeys(VariablesPaths.MY_PASSWORD);
        this.editPage.getDriver().findElement(VariablesPaths.SIGN_IN_BUTTON).click();
        this.editPage.getDriver().findElement(VariablesPaths.NAV_BAR_ADDRESSES).click();
        new WebDriverWait(this.editPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.ADDRESSES_EDIT_BUTTON));
        this.editPage.getDriver().findElement(VariablesPaths.ADDRESSES_EDIT_BUTTON).click();
        new WebDriverWait(this.editPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.UPDATE_BUTTON));
    }

    @AfterMethod
    public void testTeardown() {
        this.editPage.goToURL(VariablesPaths.EDIT_PAGE_URL);
        new WebDriverWait(this.editPage.getDriver(), 5).until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(VariablesPaths.UPDATE_BUTTON));
    }

    @AfterClass
    public void suiteTeardown() {
        this.editPage.closeDriver();
    }

    @Test
    public void testPageTitle() {
        Assert.assertEquals(this.editPage.getPageTitle(), "Address Book");
    }

    @Test
    public void testPageURL() {
        Assert.assertEquals(this.editPage.getURL(), VariablesPaths.EDIT_PAGE_URL);
    }

    @Test
    public void testUpdateButtonText() {
        Assert.assertEquals(this.editPage.getUpdateButtonText(), "Update Address");
    }

    @Test
    public void testChangeLastName() {
        Random rand = new Random();
        int x = rand.nextInt(100000);
        String newName = "johnson" + x;
        this.editPage.setNewLastName(newName);
        this.editPage.clickUpdateButton();
        List<WebElement> fetchedLastName = this.editPage.getNewLastName();
        Assert.assertEquals(fetchedLastName.get(1).getText(), newName);
    }

}
