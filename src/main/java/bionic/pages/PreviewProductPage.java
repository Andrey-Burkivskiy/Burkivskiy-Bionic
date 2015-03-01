package bionic.pages;

import bionic.support.Browser;
import org.openqa.selenium.By;

public class PreviewProductPage extends AbstractPage {

    private final By TITLE_TEXT = By.xpath(".//*[@id='offer_new']//h1");
    private final By MAP_POINT_TEXT = By.xpath(".//*[@id='offer_new']//span[contains(@class, 'show-map-link')]/strong");
    private final By PRIVATE_TEXT = By.xpath(".//div[contains(text(), 'Объявление от:')]//a");
    private final By PRODUCT_TYPE_TEXT = By.xpath(".//div[contains(text(), 'Вид товара:')]//a");
    private final By SUB_CATEGORY_TEXT = By.xpath(".//div[contains(text(), 'Подкатегории:')]//a");
    private final By CONDITION_TEXT = By.xpath(".//div[contains(text(), 'Состояние:')]//a");
    private final By DESCRIPTION_TEXT = By.id("textContent");
    private final By AUTHOR_NAME_TEXT = By.xpath(".//*[@id='offeractions']//p[contains(@class, 'userdetails')]/span[1]");
    private final By PRICE_TEXT = By.xpath(".//*[@id='offeractions']//div[contains(@class, 'pricelabel')]/strong");
    private final By PRODUCT_IMG = By.xpath(".//*[@id='offerdescription']//div[contains(@class, 'photo-handler')]/img");

    public PreviewProductPage(Browser window) {
        super(window);
    }
    
    public String getTitleText() {
        return window.findElement(TITLE_TEXT).getText();
    }
    
    public String getMapPoint() {
        return window.findElement(MAP_POINT_TEXT).getText();
        
    }
    public String getPrivateText() {
        return window.findElement(PRIVATE_TEXT).getText();
    }

    public String getProductTypeText() {
        return window.findElement(PRODUCT_TYPE_TEXT).getText();
    }
    
    public String getSubCategoryText() {
        return window.findElement(SUB_CATEGORY_TEXT).getText();
    }

    public String getConditionText() {
        return window.findElement(CONDITION_TEXT).getText();
    }
    
    public String getDescriptionText() {
        return window.findElement(DESCRIPTION_TEXT).getText();
    }
    
    public String getAuthorNameText() {
        return window.findElement(AUTHOR_NAME_TEXT).getText();

    }
    
    public String getPriceText() {
        return window.findElement(PRICE_TEXT).getText();
        
    }

    public boolean isImagePresent() {
        if (window.findElements(PRODUCT_IMG).size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
