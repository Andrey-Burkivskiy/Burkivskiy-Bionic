package bionic.pages;

import bionic.webDriver.Browser;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by andrey on 23.02.15.
 */
public class ChildrensWorldCategoryPage extends AbstractPage {
    public final By CATEGORY_NAME = By.xpath("//*[@id='top36']/h4");
    public final By CHILDREN_WEAR_CATEGORY = By.id("cat-539");
    
    public ChildrensWorldCategoryPage(Browser window) {
        super(window);
    }

    public void assertItIsChildrensWorldPage() {
        Assert.assertEquals(window.findElement(CATEGORY_NAME).getText(), "Детский мир");
    }

    public void clickOnCategoryChaildsWear() {
        window.findElement(CHILDREN_WEAR_CATEGORY).click();
    }
}
