package test.java.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import test.java.pages.*;

public class BaseTest {
    public WebDriver webDriver;
    protected HomePage homePage;
    protected TechnicalLiteraturePage technicalLiteraturePage;
    protected Header header;
    protected CartPopup cartPopup;
    protected BooksPage booksPage;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        webDriver.quit();
    }
}
