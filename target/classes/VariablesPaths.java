package main.resources;

import org.openqa.selenium.By;

public class VariablesPaths {
    public final static String WELCOME_PAGE_URL = "http://a.testaddressbook.com/";
    public final static By HEADER_1 = By.xpath("//div[@class='text-center']/h1");
    public final static By HEADER_4 = By.xpath("//div[@class='text-center']/h4");
    public final static By NAV_BAR_HOME = By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='home']");
    public final static By NAV_SIGN_IN = By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='sign-in']");
    public final static By NAV_SIGN_IN_CURRENT = By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='sign-in']/span");


    public final static String SIGN_IN_PAGE_URL = "http://a.testaddressbook.com/sign_in";
    public final static String MY_EMAIL = "waseem.ahmad1294@gmail.com";
    public final static String MY_PASSWORD = "123123";
    public final static By EMAIL_FIELD = By.id("session_email");
    public final static By PASSWORD_FIELD = By.id("session_password");
    public final static By SIGN_IN_BUTTON = By.xpath("//input[@type='submit'][@value='Sign in']");
    public final static By SIGN_UP_BUTTON = By.xpath("//div[@class='row']/a[@href='/sign_up']");
    public final static By WARNING = By.xpath("//div[@class='alert alert-notice'][text()='Bad email or password.']");


    public final static String SIGN_UP_PAGE_URL = "http://a.testaddressbook.com/sign_up";
    public final static By SIGN_UP_EMAIL_FIELD = By.id("user_email");
    public final static By SIGN_UP_PASSWORD_FIELD = By.id("user_password");
    public final static By SIGN_UP_CONFIRM = By.xpath("//div[@class='form-group row']/input[@name='commit']");
    public final static String USERS_PAGE_URL = "http://a.testaddressbook.com/users";



    public final static String HOME_PAGE_URL = "http://a.testaddressbook.com/";
    public final static By NAV_BAR_ADDRESSES = By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='addresses']");
    public final static By NAV_BAR_SIGN_OUT = By.xpath("//div[@class='navbar-nav mr-auto']/a[@data-test='sign-out']");
    public final static By SIGNED_IN_EMAIL = By.xpath("//span[@class='navbar-text'][@data-test='current-user']");


    public final static String ADDRESSES_PAGE_URL = "http://a.testaddressbook.com/addresses";
    public final static By HEADER_2 = By.xpath("//div[@class='container']/h2");
    public final static By ADDRESSES_TABLE_HEADERS = By.xpath("//table/thead/tr/th");
    public final static By ADDRESSES_TABLE_FIRST_ROW = By.xpath("//table/tbody/tr[1]/td");
    public final static By ADDRESSES_SHOW_BUTTON = By.xpath("//table/tbody/tr[1]/td[5]/a");
    public final static By ADDRESSES_EDIT_BUTTON = By.xpath("//table/tbody/tr[2]/td[6]/a");
    public final static By ADDRESSES_ADD_BUTTON = By.xpath("//a[@data-test='create']");

    public final static String SHOW_PAGE_URL = "http://a.testaddressbook.com/addresses/8919";
    public final static By SECONDARY_ADDRESS = By.xpath("//p[4]/span");
    public final static By BIRTHDAY = By.xpath("//p[9]/span");


    public final static String ADD_PAGE_URL = "http://a.testaddressbook.com/addresses/new";
    public final static By FIRST_NAME_FIELD = By.id("address_first_name");
    public final static By LAST_NAME_FIELD = By.id("address_last_name");
    public final static By ADDRESS_1_FIELD = By.id("address_street_address");
    public final static By CITY_NAME_FIELD = By.id("address_city");
    public final static By ADD_STATE_CALIFORNIA = By.xpath("//form[@class='new_address']/div/select[@name='address[state]']/option[@value='CA']");
    public final static By ADD_ZIP_CODE_FIELD = By.id("address_zip_code");
    public final static By CREATE_NEW_ADDRESS_BUTTON = By.xpath("//form[@class='new_address']/div/input[@name='commit']");
    public final static By ADDED_FIRST_NAME = By.xpath("//div[@class='container']/p/span[@data-test='first_name']");
    public final static By ADDED_LAST_NAME = By.xpath("//div[@class='container']/p/span[@data-test='last_name']");
    public final static By ADDED_ADDRESS_1_NAME = By.xpath("//div[@class='container']/p/span[@data-test='street_address']");
    public final static By ADDED_CITY_NAME = By.xpath("//div[@class='container']/p/span[@data-test='city']");
    public final static By ADDED_STATE_NAME = By.xpath("//div[@class='container']/p/span[@data-test='state']");
    public final static By ADDED_ZIP_CODE = By.xpath("//div[@class='container']/p/span[@data-test='zip_code']");
    public final static By ADDRESSES_DESTROY_BUTTON = By.xpath("//table/tbody/tr[3]/td[7]/a");
    public final static By ADDRESSES_DESTROY_NOTICE = By.xpath("//div[@class='alert alert-notice'][@data-test='notice']");
    public final static By ADDRESSES_TABLE_THIRD_ROW = By.xpath("//table/tbody/tr[4]/td");
    public final static By CONFIRM = By.xpath("//div[@class='alert alert-notice'][text()='Address was successfully created.']");
    public final static By ListButton = By.xpath("//div[@class='row justify-content-center']/a[text()='List']");


    public final static String EDIT_PAGE_URL = "http://a.testaddressbook.com/addresses/8920/edit";
    public final static By UPDATE_BUTTON = By.xpath("//input[@name='commit']");
    public final static By NEW_LAST_NAME = By.xpath("//p[2]/span");


}
