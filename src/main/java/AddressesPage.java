package main.java;

import main.resources.VariablesPaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class AddressesPage extends AddressBook {

    ChromeDriver driver;

    public AddressesPage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getHeader2Text() {
        return driver.findElement(VariablesPaths.HEADER_2).getText().trim();
    }

    public List<WebElement> getTableHeaders() {
        return driver.findElements(VariablesPaths.ADDRESSES_TABLE_HEADERS);
    }

    public List<WebElement> getTableFirstRow() {
        return driver.findElements(VariablesPaths.ADDRESSES_TABLE_FIRST_ROW);
    }

    public String getShowButtonText() {
        return driver.findElement(VariablesPaths.ADDRESSES_SHOW_BUTTON).getText().trim();
    }

    public void clickShowButton() {
        driver.findElement(VariablesPaths.ADDRESSES_SHOW_BUTTON).click();
    }

    public String getEditButtonText() {
        return driver.findElement(VariablesPaths.ADDRESSES_EDIT_BUTTON).getText().trim();
    }

    public void clickEditButton() {
        driver.findElement(VariablesPaths.ADDRESSES_EDIT_BUTTON).click();
    }

    public String getAddButtonText() {
        return driver.findElement(VariablesPaths.ADDRESSES_ADD_BUTTON).getText().trim();
    }

    public void clickAddButton() {
        driver.findElement(VariablesPaths.ADDRESSES_ADD_BUTTON).click();
    }

}
