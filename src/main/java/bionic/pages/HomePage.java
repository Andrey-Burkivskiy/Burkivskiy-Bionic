package bionic.pages;

import bionic.support.Browser;
import org.openqa.selenium.*;

public class HomePage extends AbstractPage {
    public static final String URL = "http://olx.ua/";

    private final By SEARCH_FIELD= By.id("headerSearch");
    private final By SEARCH_BUTTON = By.id("submit-searchmain");

    private final By CHILDRENS_WORLD_CATEGORY = By.id("cat-36");


    public HomePage(Browser window) {
        super(window);
    }

    public void openPage() {
        window.get(URL);
        selectRussianLang();
    }
    
    public void searchByRequest(String request) {
        window.findElement(SEARCH_FIELD).sendKeys(request);
        window.findElement(SEARCH_BUTTON).click();
    }



    public void clickOnChildrensWorldCategory() {
        window.findElement(CHILDRENS_WORLD_CATEGORY).click();
    }
}
