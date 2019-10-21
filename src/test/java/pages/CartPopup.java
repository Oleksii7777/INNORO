package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CartPopup extends BasePage {
    public CartPopup(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#cart-popup")
    public WebElement cartPopup;

    @FindBy(xpath = "//a[@name='close' and @class='btn-link-i']")
    private WebElement proceedButton;

    @FindBy(css = ".cart-check")
    private WebElement cartItemCheck;

    @FindBy(css = ".cart-i-delete")
    private WebElement removeWithNoSave;

    @FindBy(xpath = "//h1[@class='empty-cart-title inline sprite-side']")
    private WebElement emptyHeader;

    @FindBy(xpath = "//*[@id='cart-popup']//a[@class='popup-close']")
    private WebElement closePopup;

    public WebElement getCartItemByText(String text) {
        WebElement element;
        waitForElement(element = driver.findElement(By.xpath("(//a[contains(text(),'" + text + "')])[1]")));
        return element;
    }

    public void proceedBuy() {
        proceedButton.click();
    }

    public void removeWithNoSaving() {
        cartItemCheck.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(removeWithNoSave).build().perform();
        removeWithNoSave=driver.findElement(By.cssSelector(".cart-i-delete"));
        removeWithNoSave.click();
    }

    public boolean isCartEmpty() {
        return emptyHeader.isDisplayed();
    }

    public void closeCartPopup() {
        closePopup.click();
    }
}
