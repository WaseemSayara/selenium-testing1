package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.Assert;


public class TestHomePage {

    ChromeDriver driver;

    @BeforeTest
    public void TestHomePageSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://a.testaddressbook.com/");
    }

    @AfterSuite
    public void suiteTeardown(){
        driver.close();
    }

    @Test
    public void testPageTitle() {
        Assert.assertEquals(driver.getTitle(), "Address Book");
    }

    @Test
    public void testPageBodyH1() {
        WebElement h1 = driver.findElement(By.xpath("//div[@class='text-center']/h1"));
        Assert.assertTrue(h1.isDisplayed());
        Assert.assertEquals(h1.getText(), "Welcome to Address Book");
    }

    @Test
    public void testPageBodyH4() {
        WebElement h4 = driver.findElement(By.xpath("//div[@class='text-center']/h4"));
        Assert.assertTrue(h4.isDisplayed());
        Assert.assertEquals(h4.getText(), "A simple web app for showing off your testing");
    }

    @Test
    public void testNavBarHome() {
        WebElement home = driver.findElement(By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='home']"));
        Assert.assertTrue(home.isDisplayed());

    }

    @Test
    public void testNavBarLogin() {
        WebElement login = driver.findElement(By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='sign-in']"));
        Assert.assertTrue(login.isDisplayed());
    }
}
