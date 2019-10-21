package test.java.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends BasePage {
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href[contains(.,'tehnic')] and @class='pab-h3-link']")
    private WebElement technicalLiterature1;

    @FindBy(xpath = "//div[@class='portal-navigation__wrapper']//li[4]")
    private WebElement technicalLiterature2;
//it seems on this page "rozetka.com.ua" use some antibot solution and page sometimes loaded differently (https://rozetka.com.ua/ua/knigi/c4326572/)
    public void clickTechnicalLiterature() {
        try {
            technicalLiterature1.click();

        } catch (NoSuchElementException e) {
            technicalLiterature2.click();
        }
    }
}
