package bionic.pages;

import bionic.constants.Home;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
            
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebDriver getDriver() {
        return driver;
    }
    
    public void openPage() {
        driver.get(Home.URL);
    }
    
    public void searchByRequest(String request) {
        driver.findElement(Home.SEARCH_FIELD).sendKeys(request);
        driver.findElement(Home.SEARCH_BUTTON).click();
    }
    
    
}
