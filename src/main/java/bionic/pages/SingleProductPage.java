package bionic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by andrey on 24.02.15.
 */
public class SingleProductPage extends AbstractPage{
    
    public SingleProductPage(WebDriver driver) {
        super(driver);
    }
    
    private static final By PRODUCT_STATE = By.xpath(".//td[@width='203']/div");
    private static final By PRODUCT_STATE_LABEL = By.xpath(".//strong/a");
    private static final String TITLE_OF_BLOCK_WITH_PRODUCT_INOFO = "Состояние:\n";
    
    private static final By PRODUCT_TITLE = By.tagName("h1");
    
    public String getTitle() {
        return driver.findElement(PRODUCT_TITLE).getText();
    }
    
    public String getProductStateLabel() {
        return getBlockWith(TITLE_OF_BLOCK_WITH_PRODUCT_INOFO)
                .findElement(PRODUCT_STATE_LABEL).getText();
    }
    
    protected WebElement getBlockWith(String titleOfBlockWithProductInofo){
        List<WebElement> titles = driver.findElements(PRODUCT_STATE);
        for (WebElement title : titles) {
            System.out.println(title.getText());
            if (title.getText().matches("^"+titleOfBlockWithProductInofo+".*")) {
                return title;
            }
        }
        
        return null;
    }
}
