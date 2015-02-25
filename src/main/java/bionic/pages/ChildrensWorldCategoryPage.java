package bionic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by andrey on 23.02.15.
 */
public class ChildrensWorldCategoryPage extends AbstractPage {
    public final By CATEGORY_NAME = By.xpath("//*[@id='top36']/h4");
    public final By CHILDREN_WEAR_CATEGORY = By.id("cat-539");
    
    public ChildrensWorldCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void assertItIsChildrensWorldPage() {
        Assert.assertEquals(driver.findElement(CATEGORY_NAME).getText(), "Детский мир");
    }

    public void clickOnCategoryChaildsWear() {
        driver.findElement(CHILDREN_WEAR_CATEGORY).click();
    }
}
