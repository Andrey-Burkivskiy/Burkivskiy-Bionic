package bionic.TestLesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by c2612 on 18.02.2015.
 */
public class TestGitHabLogin {
    WebDriver driver;

    By login = By.id("login_field");
    By password = By.id("password");

    @Test
    public void testGitHabLogin() {
        driver.findElement(By.cssSelector("body > div.wrapper > div.header.header-logged-out > div > div.header-actions > a:nth-child(2)")).click();
        driver.findElement(login).sendKeys("Andrey-Burkivskiy");
        driver.findElement(password).sendKeys("fylhtqwtg1");
        driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span.css-truncate-target")).getText(), "Andrey-Burkivski");
    }

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://github.com/");
    }

    @AfterTest
    public void clean() {
        driver.quit();
    }
}
