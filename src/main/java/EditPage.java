package main.java;

import main.resources.VariablesPaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class EditPage extends AddressBook {

    ChromeDriver driver;

    public EditPage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setNewLastName(String newName) {
        driver.findElement(VariablesPaths.LAST_NAME_FIELD).clear();
        driver.findElement(VariablesPaths.LAST_NAME_FIELD).sendKeys(newName);
    }

    public List<WebElement> getNewLastName() {
        return driver.findElements(VariablesPaths.NEW_LAST_NAME);
    }

    public String getUpdateButtonText() {
        return driver.findElement(VariablesPaths.UPDATE_BUTTON).getAttribute("value").trim();
    }

    public void clickUpdateButton() {
        driver.findElement(VariablesPaths.UPDATE_BUTTON).click();
    }

}
