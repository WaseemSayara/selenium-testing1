package main.java;

import main.resources.XPaths;
import org.openqa.selenium.chrome.ChromeDriver;


public class AddPage {

    ChromeDriver driver;

    public AddPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public ChromeDriver getDriver() {
        return driver;
    }

    public void goToURL(String URL) {
        driver.get(URL);
    }

    public void closeDriver() {
        driver.close();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void setAddFirstName(String firstName) {
        driver.findElement(XPaths.addFirstNameField).clear();
        driver.findElement(XPaths.addFirstNameField).sendKeys(firstName);
    }

    public void setAddLastName(String lastName) {
        driver.findElement(XPaths.addLastNameField).clear();
        driver.findElement(XPaths.addLastNameField).sendKeys(lastName);
    }

    public void setAddAddress1(String address1) {
        driver.findElement(XPaths.addAddress1Field).clear();
        driver.findElement(XPaths.addAddress1Field).sendKeys(address1);
    }

    public void setAddCity(String city) {
        driver.findElement(XPaths.addCityNameField).clear();
        driver.findElement(XPaths.addCityNameField).sendKeys(city);
    }

    public void setAddState() {
        driver.findElement(XPaths.addStateCalifornia).click();

    }

    public void setAddZipCode(String zipCode) {
        driver.findElement(XPaths.addZipCodeField).clear();
        driver.findElement(XPaths.addZipCodeField).sendKeys(zipCode);
    }

    public void clickUpdateButton() {
        driver.findElement(XPaths.createNewAddressButton).click();
    }

    public String getAddedFirstName() {
        return driver.findElement(XPaths.addedFirstName).getText().trim();
    }

    public String getAddedLastName() {
        return driver.findElement(XPaths.addedLastName).getText().trim();
    }

    public String getAddedAddress1() {
        return driver.findElement(XPaths.addedAddress1Name).getText().trim();
    }

    public String getAddedCity() {
        return driver.findElement(XPaths.addedCityName).getText().trim();
    }

    public String getAddedState() {
        return driver.findElement(XPaths.addedStateName).getText().trim();
    }

    public String getAddedZipCode() {
        return driver.findElement(XPaths.addedZipCode).getText().trim();
    }

    public void clickDestroyButton() {
        driver.findElement(XPaths.addressesDestroyButton).click();
    }

    public String getDestroyNotice() {
        return driver.findElement(XPaths.addressesDestroyNotice).getText().trim();
    }

}
