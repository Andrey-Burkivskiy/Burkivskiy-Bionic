package bionic;

import bionic.constants.Settings;
import bionic.support.Browser;
import bionic.steps.AbstractUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    private WebDriver driver;
    protected Browser window;
    protected Actions actions;
    

    @BeforeClass
    public void setUp() throws IOException {
        driver = new FirefoxDriver();
        window = new Browser(driver);
        actions = new Actions(window.driver);
        window.manage().window().maximize();
        window.manage().timeouts().implicitlyWait(Settings.TIMEOUT, TimeUnit.SECONDS);
        window.manage().timeouts().pageLoadTimeout(Settings.TIMEOUT, TimeUnit.SECONDS);
        window.manage().timeouts().setScriptTimeout(Settings.TIMEOUT, TimeUnit.SECONDS);
    }

    @AfterClass
    public void clean() {
//        window.quit();
    }

    protected void returnDriverFrom(AbstractUser user) {
        window = user.getWindow();
    }
}
