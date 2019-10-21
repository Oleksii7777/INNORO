package test.java.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFirefox implements Driver {
    public WebDriver startBrowser() {
        return new FirefoxDriver();
    }
}
