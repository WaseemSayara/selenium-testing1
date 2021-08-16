import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.Assert;

import java.util.List;

public class TestAddressesPage {

    ChromeDriver driver;
    String myEmail = "waseem.ahmad1294@gmail.com";
    String myPassword = "123123";

    @BeforeMethod
    public void TestLoginPageSetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://a.testaddressbook.com/");
        WebElement login= driver.findElement(By.id("sign-in"));
        login.click();
        Thread.sleep(1000);
        WebElement email=driver.findElement(By.xpath("//div[@class='form-group row']/input[@name='session[email]']"));
        WebElement password=driver.findElement(By.xpath("//input[@type='password'][@name='session[password]']"));
        WebElement loginButton=driver.findElement(By.xpath("//input[@type='submit'][@value='Sign in']"));
        email.sendKeys(myEmail);
        password.sendKeys(myPassword);
        loginButton.click();
        WebElement navBarAddresses= driver.findElement(By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='addresses']"));
        navBarAddresses.click();
        Thread.sleep(1000);
    }

    @AfterMethod
    public void suiteTeardown() {
        driver.close();
    }

    @Test
    public void testPageTitle() {
        Assert.assertEquals(driver.getTitle(),"Address Book");
    }

    @Test
    public void testPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(),"http://a.testaddressbook.com/addresses");
    }

    @Test
    public void testPageBodyH2() {
        WebElement h2 = driver.findElement(By.xpath("//div[@class='text-center']/h2"));
        Assert.assertTrue(h2.isDisplayed());
        Assert.assertEquals(h2.getText(), "Addresses");
    }

    @Test
    public void testNavBarHome() {
        WebElement navBarHome= driver.findElement(By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='home']"));
        Assert.assertTrue(navBarHome.isDisplayed());
    }

    @Test
    public void testNavBarSignOut() {
        WebElement navBarSignOut= driver.findElement(By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='sign-out']"));
        Assert.assertTrue(navBarSignOut.isDisplayed());
    }

    @Test
    public void testNavBarAddresses() {
        WebElement navBarAddresses= driver.findElement(By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='addresses']"));
        Assert.assertTrue(navBarAddresses.isDisplayed());
    }

    @Test
    public void testInEmail(){
        WebElement loggedInEmail=driver.findElement(By.xpath("//span[@class='navbar-text'][@data-test='current-user']"));
        Assert.assertEquals(myEmail,loggedInEmail.getText());
    }

    @Test
    public void testButtonClickSignOut() {
        WebElement navBarSignOut= driver.findElement(By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='sign-out']"));
        navBarSignOut.click();
        Assert.assertEquals(driver.getTitle(), "Address Book - Sign In");
    }

    @Test
    public void testTableHeaders(){
        List<WebElement> tableHeaders= driver.findElements(By.xpath("//table/thead/tr/th"));
        Assert.assertEquals(tableHeaders.get(0).getText(), "First name");
        Assert.assertEquals(tableHeaders.get(1).getText(), "Last name");
        Assert.assertEquals(tableHeaders.get(2).getText(), "City");
        Assert.assertEquals(tableHeaders.get(3).getText(), "State");
    }

    @Test
    public void testFirstRow(){
        List<WebElement> firstRow= driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
        Assert.assertEquals(firstRow.get(0).getText(), "waseem");
        Assert.assertEquals(firstRow.get(1).getText(), "sayara");
        Assert.assertEquals(firstRow.get(2).getText(), "ramallah");
        Assert.assertEquals(firstRow.get(3).getText(), "AL");
        Assert.assertEquals(firstRow.get(4).getText(), "Show");
        Assert.assertEquals(firstRow.get(5).getText(), "Edit");
        Assert.assertEquals(firstRow.get(6).getText(), "Destroy");
    }

    @Test
    public void testShowButton() {
        WebElement showButton= driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]/a"));
        showButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://a.testaddressbook.com/addresses/8175");
    }

    @Test
    public void testEditButton() {
        WebElement editButton= driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]/a"));
        editButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://a.testaddressbook.com/addresses/8175/edit");
    }

}
