package bionic.pages;

import org.openqa.selenium.*;

public class HomePage extends AbstractPage {
    public static final String URL = "http://olx.ua/";

    private static final By SEARCH_FIELD= By.id("headerSearch");
    private static final By SEARCH_BUTTON = By.id("submit-searchmain");

    private static final By CHILDRENS_WORLD_CATEGORY = By.id("cat-36");
    

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
        selectRussianLang();
    }
    
    public void searchByRequest(String request) {
        driver.findElement(SEARCH_FIELD).sendKeys(request);
        driver.findElement(SEARCH_BUTTON).click();
    }



    public void clickOnChildrensWorldCategory() {
        driver.findElement(CHILDRENS_WORLD_CATEGORY).click();
    }
}
