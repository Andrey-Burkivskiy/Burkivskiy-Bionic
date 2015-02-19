package bionic.steps;

import bionic.constants.Settings;
import bionic.pages.HomePage;
import bionic.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class UnregisteredUser {
    WebDriver driver;

    public void searchFromHomePageByRequest(String request) {
        HomePage home = new HomePage(driver);
        
        home.openPage();
        home.searchByRequest(request);

        driver = home.getDriver();
    }

    public void accertThatTitleOfFirstProductInNewProductsContainsRequest(String request) {
        SearchResultsPage searchResults = new SearchResultsPage(driver);
        String titleOfFirstProduct = searchResults.readTitleOfFirstProductInNewProductsContainsRequest(request);
        String regExp = ".*(?i:" + request + ").*";
        String message = "Title of first (" + titleOfFirstProduct + ") product doesn't contains request: " + request;

        driver = searchResults.getDriver();
        Assert.assertEquals(titleOfFirstProduct.matches(regExp), true, message);
    }

    public void openFireFox() {
        this.driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Settings.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Settings.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(Settings.TIMEOUT, TimeUnit.SECONDS);
    }

    public void closeBrouser() {
        driver.quit();
    }
}
