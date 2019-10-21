package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class TechnicalLiteraturePage extends BasePage {
    public TechnicalLiteraturePage(WebDriver driver) {
        super(driver);
    }
    private final String sortButtonXPath="//a[@class='dropdown-link sort-view-link sprite-both']";
    @FindBy(css = ".lb")
    private WebElement leftPicker;

    @FindBy(css = ".rb")
    private WebElement rightPicker;

    @FindBy(css = ".cb")
    private WebElement centralSlider;

    @FindBy(css = "#submitprice")
    private WebElement submitPriceButton;

    @FindBy(xpath = "(//span[@class='limit'])[2]")
    private WebElement spanWithMaxPrice;

    @FindBy(xpath = "//div[@param[contains(.,\'izdatelstvo\')]]//a[@name=\'show_more_parameters\']")
    private WebElement showMoreIzdatelstvo;

    @FindBy(xpath = "//i[text()='Диалектика']")
    private WebElement dialecticaIzdatelstvo;

    @FindBy(xpath = sortButtonXPath)
    private WebElement sortButton;

    @FindBy(xpath = "//@href[contains(.,'sort=popularity')]/..")
    private WebElement popularitySubMenu;


    private void movePicker(WebElement picker, int xOffset) {
        Actions actions = new Actions(driver);
        actions.moveToElement(picker).clickAndHold().moveByOffset(xOffset, 0).release().perform();
    }

    public void selectPriceRangeAndSubmit(int desiredMin, int desiredMax) {
        int sliderLength = centralSlider.getSize().width;
        int sliderMaxPrice = Integer.parseInt(spanWithMaxPrice.getAttribute("innerText"));
        int priceForOnePX = sliderMaxPrice / sliderLength;
        int leftPickerXOffset = desiredMin / priceForOnePX;
        int rightPickerXOffset = (desiredMax - sliderMaxPrice) / priceForOnePX;
        movePicker(leftPicker, leftPickerXOffset);
        movePicker(rightPicker, rightPickerXOffset);
        submitPriceButton.click();
        waitPageFullyLoaded();
    }

    public void selectDialecticaIzdatelstvo() {
        waitPageFullyLoaded();
        Actions actions = new Actions(driver);
        actions.moveToElement(showMoreIzdatelstvo).release().perform();
        showMoreIzdatelstvo.click();
        actions.moveToElement(dialecticaIzdatelstvo).release().perform();
        dialecticaIzdatelstvo.click();
        waitPageFullyLoaded();
    }

    public void sortByPopularity() {
        waitPageFullyLoaded();
        Actions actions = new Actions(driver);
        sortButton = driver.findElement(By.xpath((sortButtonXPath)));
        actions.moveToElement(sortButton).release().perform();
        sortButton = driver.findElement(By.xpath((sortButtonXPath)));
        sortButton.click();
        popularitySubMenu.click();
        waitPageFullyLoaded();
    }

    public boolean isBookLinkByTextDisplayed(String text) {
        waitPageFullyLoaded();
        WebElement element=driver.findElement(By.xpath("//a[contains(text(),'" + text + "')]"));
        return element.isDisplayed();
    }

    public void buyBookByName(String text) {
        waitPageFullyLoaded();
        WebElement element=driver.findElement(By.xpath("(//a[contains(text(),'" + text + "')]/../..//button)[1]"));
        element.click();
    }

}
