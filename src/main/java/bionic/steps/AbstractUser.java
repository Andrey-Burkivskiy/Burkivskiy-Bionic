package bionic.steps;

import bionic.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by andrey on 24.02.15.
 */
public class AbstractUser {

    WebDriver driver;
    
    protected AbstractUser(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void returnDriverFrom(AbstractPage page) {
        driver = page.getDriver();
    }
}
