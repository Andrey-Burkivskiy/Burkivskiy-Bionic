package bionic;

import bionic.constants.Settings;
import bionic.webDriver.Browser;
import bionic.steps.AbstractUser;
import bionic.utils.PropertyLoader;
import bionic.webDriver.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    private WebDriver driver;
    protected Browser window;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = BrowserFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        window = new Browser(driver);
        window.manage().timeouts().implicitlyWait(Settings.TIMEOUT, TimeUnit.SECONDS);
        window.manage().timeouts().pageLoadTimeout(Settings.TIMEOUT, TimeUnit.SECONDS);
        window.manage().timeouts().setScriptTimeout(Settings.TIMEOUT, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void clean() {
        window.quit();
    }

    protected void returnDriverFrom(AbstractUser user) {
        window = user.getWindow();
    }
}
