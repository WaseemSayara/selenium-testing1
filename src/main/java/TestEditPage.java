

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class TestEditPage {

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
        WebElement showButton= driver.findElement(By.xpath("//table/tbody/tr[2]/td[6]/a"));
        showButton.click();
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
        Assert.assertEquals(driver.getCurrentUrl(),"http://a.testaddressbook.com/addresses/8175/edit");
    }

   @Test
   public void testChangeLastName(){
        WebElement lastName = driver.findElement(By.xpath("//input[@name='address[last_name]']"));
        Random rand = new Random();
        int x = rand.nextInt(10000);
        String newName = "mahmod" + x;
        lastName.clear();
        lastName.sendKeys(newName);
        WebElement updateButton = driver.findElement(By.xpath("//input[@name='commit']"));
        updateButton.click();

       List<WebElement> newLastName = driver.findElements(By.xpath("//p[2]/span"));
       Assert.assertEquals(newLastName.get(0).getText(), "Last name:");
       Assert.assertEquals(newLastName.get(1).getText(), newName);

   }

}
