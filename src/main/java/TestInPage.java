import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.Assert;

public class TestInPage {

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

}
