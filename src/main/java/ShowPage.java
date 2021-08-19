package main.java;

import main.resources.VariablesPaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class ShowPage extends AddressBook {

    ChromeDriver driver;

    public ShowPage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public List<WebElement> getSecAddress() {
        return driver.findElements(VariablesPaths.SECONDARY_ADDRESS);
    }

    public List<WebElement> getBirthday() {
        return driver.findElements(VariablesPaths.BIRTHDAY);
    }

}
