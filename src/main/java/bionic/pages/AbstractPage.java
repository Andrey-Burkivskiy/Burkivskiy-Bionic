package bionic.pages;

import bionic.constants.Settings;
import bionic.support.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {
    Browser window;
    private final By ACTIVE_LANG = By.id("changeLang");
    
    public AbstractPage(Browser window) {
        this.window = window;
    }

    public Browser getWindow() {
        return window;
    }
    
    protected boolean isElementPresent(By locator) {
        List<WebElement> elements = window.findElements(locator);
        if (elements.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    protected void waitWhenElementDisappears(By locator) {
        while (isElementPresent(locator)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    protected void waitWhenElementPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(window, Settings.TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    protected void selectRussianLang() {
        if (window.findElement(ACTIVE_LANG).getText().equals("язык")) {
            window.findElement(ACTIVE_LANG).click();
        }
        
    }
    
}
