package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".hub-i-count")
    private WebElement countItemsInCart;

    @FindBy(css = "#cart_popup_header")
    private WebElement cart;

    @FindBy(xpath = "//li[@id='cart_popup_header']//a/span")
    private WebElement cartPopupGoToCart;


    public String getCountItemsInCart() {
        return countItemsInCart.getText();
    }

    public void goToCartFromCartPopup() {
        Actions actions = new Actions(driver);
        actions.moveToElement(cart);
        actions.perform();
        cartPopupGoToCart.click();

    }
}
