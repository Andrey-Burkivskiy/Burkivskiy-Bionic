package bionic.steps;

import bionic.pages.AbstractPage;
import bionic.support.Browser;
import org.openqa.selenium.WebDriver;

/**
 * Created by andrey on 24.02.15.
 */
public class AbstractUser {

    Browser driver;
    
    protected AbstractUser(WebDriver driver) {
        this.driver = new Browser(driver);
    }

    public Browser getDriver() {
        return driver;
    }

    protected void returnDriverFrom(AbstractPage page) {
        driver = page.getDriver();
    }
}
