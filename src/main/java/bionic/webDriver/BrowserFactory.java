package bionic.webDriver;

import bionic.utils.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class BrowserFactory {
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String IE = "ie";
    public static WebDriver initDriver(String browserName) {
        WebDriver driver = null;
        if (browserName.equals(FIREFOX)) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else
        if (browserName.equals(CHROME)) {
            File file = new File(PropertyLoader.loadProperty("selenium.chrome.driver.path"));
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new ChromeDriver();
        } else 
        if (browserName.equals(IE)) {
            
        } else {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        
        return driver;
    }
}
