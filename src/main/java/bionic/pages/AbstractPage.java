package bionic.pages;

import bionic.constants.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class AbstractPage {
    Browser driver;
    private static final By ACTIVE_LANG = By.id("changeLang");
    
    public AbstractPage(WebDriver driver) {
        this.driver = new Browser(driver);
    }

    public Browser getDriver() {
        return driver;
    }
    
    protected boolean isElementPresent(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        if (elements.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    protected void waitWhenElementDisappears(By locator) {
//        while (isElementPresent(locator)) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        WebDriverWait wait = new WebDriverWait(driver, Settings.TIMEOUT);
        wait.until(not(ExpectedConditions.presenceOfElementLocated(locator)));
    }
    
    protected void waitWhenElementPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Settings.TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    protected void selectRussianLang() {
        if (driver.findElement(ACTIVE_LANG).getText().equals("язык")) {
            driver.findElement(ACTIVE_LANG).click();
        }
        
    }
    
}
