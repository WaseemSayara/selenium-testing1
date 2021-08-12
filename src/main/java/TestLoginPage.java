
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.Assert;

public class TestLoginPage {

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
    }

    @AfterMethod
    public void suiteTeardown() {
        driver.close();
    }

    @Test
    public void testPageTitle() {
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Address Book - Sign In");
    }

    @Test
    public void testInputEmail() {
        System.out.println(driver.getTitle());
        WebElement email=driver.findElement(By.xpath("//div[@class='form-group row']/input[@name='session[email]']"));
        Assert.assertTrue(email.isDisplayed());
    }

    @Test
    public void testInputPassword() {
        System.out.println(driver.getTitle());
        WebElement password=driver.findElement(By.xpath("//input[@type='password'][@name='session[password]']"));
        Assert.assertTrue(password.isDisplayed());
    }
    @Test
    public void testButtonLogin() {
        System.out.println(driver.getTitle());
        WebElement loginButton=driver.findElement(By.xpath("//input[@type='submit'][@value='Sign in']"));
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @Test
    public void testSuccessLogin() {
        System.out.println(driver.getTitle());
        WebElement email=driver.findElement(By.xpath("//div[@class='form-group row']/input[@name='session[email]']"));
        WebElement password=driver.findElement(By.xpath("//input[@type='password'][@name='session[password]']"));
        WebElement loginButton=driver.findElement(By.xpath("//input[@type='submit'][@value='Sign in']"));
        email.sendKeys(myEmail);
        password.sendKeys(myPassword);
        loginButton.click();
        WebElement loggedInEmail=driver.findElement(By.xpath("//span[@class='navbar-text'][@data-test='current-user']"));
        Assert.assertEquals(myEmail,loggedInEmail.getText());
    }

    @Test
    public void testFailedLogin() {
        System.out.println(driver.getTitle());
        WebElement email=driver.findElement(By.xpath("//div[@class='form-group row']/input[@name='session[email]']"));
        WebElement password=driver.findElement(By.xpath("//input[@type='password'][@name='session[password]']"));
        WebElement loginButton=driver.findElement(By.xpath("//input[@type='submit'][@value='Sign in']"));
        email.sendKeys("waseem@gmail.com");
        password.sendKeys(myPassword);
        loginButton.click();
        WebElement message=driver.findElement(By.xpath("//div[@class='alert alert-notice'][@data-test='notice']"));
        Assert.assertEquals(message.getText(), "Bad email or password.");
    }
}
