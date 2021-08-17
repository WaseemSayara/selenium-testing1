package main.resources;

import org.openqa.selenium.By;

public class XPaths {
    public final static String welcomePageURL = "http://a.testaddressbook.com/";
    public final static By header1 = By.xpath("//div[@class='text-center']/h1");
    public final static By header4 = By.xpath("//div[@class='text-center']/h4");
    public final static By navBarHome = By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='home']");
    public final static By navSignIn = By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='sign-in']");
    public final static By navSignInCurrent = By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='sign-in']/span");


    public final static String signInPageURL = "http://a.testaddressbook.com/sign_in";
    public final static String myEmail = "waseem.ahmad1294@gmail.com";
    public final static String myPassword = "123123";
    public final static By emailField = By.xpath("//div[@class='form-group row']/input[@name='session[email]']");
    public final static By passwordField = By.xpath("//input[@type='password'][@name='session[password]']");
    public final static By signInButton = By.xpath("//input[@type='submit'][@value='Sign in']");
    public final static By signUpButton = By.xpath("//div[@class='row']/a[@href='/sign_up']");
    public final static By warning = By.xpath("//div[@class='alert alert-notice'][text()='Bad email or password.']");


    public final static String homePageURL = "http://a.testaddressbook.com/";
    public final static By navBarAddresses = By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='addresses']");
    public final static By navBarSignOut = By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='sign-out']");
    public final static By SignedInEmail = By.xpath("//span[@class='navbar-text'][@data-test='current-user']");


    public final static String addressesPageURL = "http://a.testaddressbook.com/addresses";
    public final static By header2 = By.xpath("//div[@class='container']/h2");
    public final static By addressesTableHeaders = By.xpath("//table/thead/tr/th");
    public final static By addressesTableFirstRow = By.xpath("//table/tbody/tr[1]/td");
    public final static By addressesShowButton = By.xpath("//table/tbody/tr[1]/td[5]/a");
    public final static By addressesEditButton = By.xpath("//table/tbody/tr[2]/td[6]/a");
    public final static By addressesAddButton = By.xpath("//a[@data-test='create']");

    public final static String showPageURL = "http://a.testaddressbook.com/addresses/8175";
    public final static By secondaryAddress = By.xpath("//p[4]/span");
    public final static By birthday = By.xpath("//p[9]/span");

    public final static String editPageURL = "http://a.testaddressbook.com/addresses/8748/edit";
    public final static By lastNameField = By.xpath("//input[@name='address[last_name]']");
    public final static By updateButton = By.xpath("//input[@name='commit']");
    public final static By newLastName = By.xpath("//p[2]/span");

    public final static String addPageURL = "http://a.testaddressbook.com/addresses/new";

}
