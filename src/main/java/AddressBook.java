package main.java;

import org.openqa.selenium.chrome.ChromeDriver;

public class AddressBook {

    ChromeDriver driver;

    public AddressBook(ChromeDriver driver) {
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
}
