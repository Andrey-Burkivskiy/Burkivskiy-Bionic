package bionic.TestLesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by c2612 on 18.02.2015.
 */
public class TestWiki {
    WebDriver driver;

    @Test
    public void testWiki() {
        driver.get("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        Assert.assertEquals(driver.findElement(By.cssSelector("#p-logo > a")).isEnabled(), true, "Logo doesn't displayed on page");
    }

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void clean() {
        driver.close();
    }
}
