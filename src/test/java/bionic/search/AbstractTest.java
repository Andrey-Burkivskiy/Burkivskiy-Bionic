package bionic.search;

import bionic.constants.Settings;
import bionic.support.Browser;
import bionic.steps.AbstractUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    WebDriver defaultDriver;
    protected Browser driver;
    

    @BeforeClass
    public void setUp() throws IOException {

        defaultDriver = new FirefoxDriver();
        driver = new Browser(defaultDriver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Settings.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Settings.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(Settings.TIMEOUT, TimeUnit.SECONDS);
    }

    @AfterClass
    public void clean() {
        driver.quit();
    }

    protected void returnDriverFrom(AbstractUser user) {
        driver = user.getDriver();
    }
}
