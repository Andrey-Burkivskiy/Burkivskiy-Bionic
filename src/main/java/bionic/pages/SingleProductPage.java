package bionic.pages;

import bionic.support.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SingleProductPage extends AbstractPage{
    
    public SingleProductPage(Browser window) {
        super(window);
    }

    //.//div[contains(text(), 'Состояние:')]//a
    private final By PRODUCT_STATE = By.xpath(".//td[@width='203']/div");
    private final By PRODUCT_STATE_LABEL = By.xpath(".//strong/a");
    private final String TITLE_OF_BLOCK_WITH_PRODUCT_INFO = "Состояние:" + System.getProperty("line.separator");
    
    private final By PRODUCT_TITLE = By.tagName("h1");
    
    public String getTitle() {
        return window.findElement(PRODUCT_TITLE).getText();
    }
    
    public String getProductStateLabel() {
        return getBlockWith(TITLE_OF_BLOCK_WITH_PRODUCT_INFO)
                .findElement(PRODUCT_STATE_LABEL).getText();
    }
    
    protected WebElement getBlockWith(String titleOfBlockWithProductInfo){
        List<WebElement> titles = window.findElements(PRODUCT_STATE);
        for (WebElement title : titles) {
            if (title.getText().matches("^"+titleOfBlockWithProductInfo+".*")) {
                return title;
            }
        }
        
        return null;
    }
}
