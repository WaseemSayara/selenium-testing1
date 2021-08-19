package main.java;

import main.resources.VariablesPaths;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class AddPage extends AddressBook {

    ChromeDriver driver;

    public AddPage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setAddFirstName(String firstName) {
        driver.findElement(VariablesPaths.FIRST_NAME_FIELD).clear();
        driver.findElement(VariablesPaths.FIRST_NAME_FIELD).sendKeys(firstName);
    }

    public void setAddLastName(String lastName) {
        driver.findElement(VariablesPaths.LAST_NAME_FIELD).clear();
        driver.findElement(VariablesPaths.LAST_NAME_FIELD).sendKeys(lastName);
    }

    public void setAddAddress1(String address1) {
        driver.findElement(VariablesPaths.ADDRESS_1_FIELD).clear();
        driver.findElement(VariablesPaths.ADDRESS_1_FIELD).sendKeys(address1);
    }

    public void setAddCity(String city) {
        driver.findElement(VariablesPaths.CITY_NAME_FIELD).clear();
        driver.findElement(VariablesPaths.CITY_NAME_FIELD).sendKeys(city);
    }

    public void setAddState() {
        driver.findElement(VariablesPaths.ADD_STATE_CALIFORNIA).click();

    }

    public void setAddZipCode(String zipCode) {
        driver.findElement(VariablesPaths.ADD_ZIP_CODE_FIELD).clear();
        driver.findElement(VariablesPaths.ADD_ZIP_CODE_FIELD).sendKeys(zipCode);
    }

    public void clickUpdateButton() {
        driver.findElement(VariablesPaths.CREATE_NEW_ADDRESS_BUTTON).click();
    }

    public String getAddedFirstName() {
        return driver.findElement(VariablesPaths.ADDED_FIRST_NAME).getText().trim();
    }

    public String getAddedLastName() {
        return driver.findElement(VariablesPaths.ADDED_LAST_NAME).getText().trim();
    }

    public String getAddedAddress1() {
        return driver.findElement(VariablesPaths.ADDED_ADDRESS_1_NAME).getText().trim();
    }

    public String getAddedCity() {
        return driver.findElement(VariablesPaths.ADDED_CITY_NAME).getText().trim();
    }

    public String getAddedState() {
        return driver.findElement(VariablesPaths.ADDED_STATE_NAME).getText().trim();
    }

    public String getAddedZipCode() {
        return driver.findElement(VariablesPaths.ADDED_ZIP_CODE).getText().trim();
    }

    public void clickDestroyButton(String path) {
        driver.findElement(By.xpath(path)).click();
    }

    public void clickListButton() {
        driver.findElement(VariablesPaths.ListButton).click();
    }

    public String getDestroyNotice() {
        return driver.findElement(VariablesPaths.ADDRESSES_DESTROY_NOTICE).getText().trim();
    }

    public String getAdditionConfirmText() {
        return driver.findElement(VariablesPaths.CONFIRM).getText().trim();
    }

    public String toDeletePathCreator(String[] data, String state) {
        String path = "//tr";
        for (int i = 0; i <= 3; i++) {
            if (i != 2)
                path += "[td//text()='" + data[i] + "']";
        }
        path += "[td//text()='" + state + "']";
        return path;
    }

}
