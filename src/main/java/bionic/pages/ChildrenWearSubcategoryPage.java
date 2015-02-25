package bionic.pages;

import bionic.support.FindSubString;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class ChildrenWearSubcategoryPage extends AbstractPage {
    public static final String URL = "http://olx.ua/detskiy-mir/detskaya-odezhda/";
    
    private static final By SUB_CATEGORY_NAME = By.cssSelector("h1.fnormal");
    
    private static final By STATE_FILTER_BUTTON = By.cssSelector("#param_state>div>a");
    private static final By STATE_FILTER_NEW_PRODUCT = By.id("f-new_state");

    private static final By FILTER_BOTTOM_LIMITS_BLOCK = By.xpath(".//*[@id='param_price']/div/div[contains(@class, 'filter-item-from')]");
    private static final By FILTER_TOP_LIMITS_BLOCK = By.xpath(".//*[@id='param_price']/div/div[contains(@class, 'filter-item-to')]");
    private static final By FILTER_LIMITS_BUTTON = By.xpath(".//span[contains(@data-default-label, 'Цена')]");
    private static final By FILTER_LIMITS_FIELD = By.cssSelector(".vtop.ca2");

    private static final Integer FILTER_BOTTOM_LIMITS = 100;
    private static final Integer FILTER_TOP_LIMITS = 1500;
    
    private static final By SPINNER = By.cssSelector("div.listOverlay");
    
    private static final By PRODUCTS = By.cssSelector("td.offer");
    private WebElement product;
    private static final By PRODUCTS_TITLE_LINK = By.cssSelector("h3>.linkWithHash");
    private static final By PRODUCTS_TITLE_TEXT = By.cssSelector("h3>.linkWithHash>span");
    private static final By PRODUCTS_PRICE = By.cssSelector(".td-price>div>p>strong");
    
    
    public ChildrenWearSubcategoryPage(WebDriver driver) {
        super(driver);
    }

    public void assertItIsChildrenWearPage() {
        Assert.assertEquals(driver.findElement(SUB_CATEGORY_NAME).getText(), "Продажа детской одежды");
    }
    
    public void selectFilterNewProducts() {
        driver.findElement(STATE_FILTER_BUTTON).click();
        driver.findElement(STATE_FILTER_NEW_PRODUCT).click();
        waitWhenElementDisappears(SPINNER);
    }
    
    public void openRundomProductFromList() {
        product.findElement(PRODUCTS_TITLE_LINK).click();
    }
    
    public void assertThatPriceOfProductOnFirstPageIsInFilterLimits() {
        List<WebElement> products = driver.findElements(PRODUCTS);
        for (WebElement product : products) {
            String strTitle = product.findElement(PRODUCTS_TITLE_TEXT).getText();
            String strProductPrice = product.findElement(PRODUCTS_PRICE).getText();
            Integer productPrice = Integer.valueOf(FindSubString.getSubString(strProductPrice, "[0-9]+(\\.|,)?[0-9]*"));
            Assert.assertEquals(productPrice >= FILTER_BOTTOM_LIMITS && productPrice <= FILTER_TOP_LIMITS, true, "Price of product (title: \""  + strTitle + "\" price: " + strProductPrice + ") is not in filter limits("+FILTER_BOTTOM_LIMITS+" - "+FILTER_TOP_LIMITS+").");
        }

    }

    public void chooseRandomProductFromList() {
        Random random = new Random();
        List<WebElement> prices = driver.findElements(PRODUCTS);
        product = prices.get(random.nextInt(prices.size()));
    }
    
    public String getTitleOfProduct() {
        return product.findElement(PRODUCTS_TITLE_TEXT).getText();
    }

    public void openPage() {
        driver.get(URL);
    }

    public void setBottomPrice() {
        driver.findElement(FILTER_BOTTOM_LIMITS_BLOCK).findElement(FILTER_LIMITS_BUTTON).click();
        driver.findElement(FILTER_BOTTOM_LIMITS_BLOCK).findElement(FILTER_LIMITS_FIELD).sendKeys(FILTER_BOTTOM_LIMITS.toString());
        driver.findElement(FILTER_BOTTOM_LIMITS_BLOCK).sendKeys(Keys.RETURN);
        waitWhenElementDisappears(SPINNER);
    }

    public void setTopPrice() {
        driver.findElement(FILTER_TOP_LIMITS_BLOCK).findElement(FILTER_LIMITS_BUTTON).click();
        driver.findElement(FILTER_TOP_LIMITS_BLOCK).findElement(FILTER_LIMITS_FIELD).sendKeys(FILTER_TOP_LIMITS.toString());
        driver.findElement(FILTER_TOP_LIMITS_BLOCK).sendKeys(Keys.RETURN);
        waitWhenElementDisappears(SPINNER);
    }
    
}
