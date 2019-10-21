package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".menu-toggler__text")
    private WebElement catalogButton;

    @FindBy(xpath = "(//@href[contains(.,'office-school-books')])[1]/..")
    private WebElement officeSchoolBooks;

    @FindBy(xpath = "//a[@class='menu__hidden-title' and @href[contains(.,'knigi')]]")
    private WebElement booksSubMenu;

    public void open() {
        driver.get("http://rozetka.com.ua");
    }

    public void clickCatalogButton() {
        catalogButton.click();
    }

    public void selectBookFromOfficeSchoolBooks() {
        Actions actions = new Actions(driver);
        actions.moveToElement(officeSchoolBooks);
        actions.moveToElement(booksSubMenu);
        actions.click();
        actions.perform();
    }
}
