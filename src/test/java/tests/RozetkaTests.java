package test.java.tests;

import test.java.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.java.pages.*;


public class RozetkaTests {

    private WebDriver webDriver;
    private DriverFactory driverFactory = new DriverFactory();

    @Parameters({"browser"})
    @Test
    public void testRozetka1(String browser) {
        String bookName = "Java. Полное руководство";
        SoftAssert s_assert = new SoftAssert();
        webDriver = driverFactory.getDriver(browser).startBrowser();
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickCatalogButton();
        homePage.selectBookFromOfficeSchoolBooks();
        BooksPage booksPage = new BooksPage(webDriver);
        booksPage.clickTechnicalLiterature();
        TechnicalLiteraturePage technicalLiteraturePage = new TechnicalLiteraturePage(webDriver);
        technicalLiteraturePage.selectPriceRangeAndSubmit(300, 1500);
        technicalLiteraturePage.selectDialecticaIzdatelstvo();
        technicalLiteraturePage.sortByPopularity();
        s_assert.assertTrue(technicalLiteraturePage.isBookLinkByTextDisplayed(bookName), "in technical literature book not displayed");
        technicalLiteraturePage.buyBookByName(bookName);
        CartPopup cartPopup = new CartPopup(webDriver);
        s_assert.assertTrue(cartPopup.cartPopup.isDisplayed(), "cart popup not displayed");
        s_assert.assertTrue(cartPopup.getCartItemByText(bookName).isDisplayed(), "book not displayed in cart");
        cartPopup.proceedBuy();
        Header header = new Header(webDriver);
        s_assert.assertTrue(header.getCountItemsInCart().equals("1"), "wrong count of items in cart");
        header.goToCartFromCartPopup();
        cartPopup.removeWithNoSaving();
        s_assert.assertTrue(cartPopup.isCartEmpty(), "cart is not empty");
        cartPopup.closeCartPopup();
        s_assert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        webDriver.quit();
    }

}
