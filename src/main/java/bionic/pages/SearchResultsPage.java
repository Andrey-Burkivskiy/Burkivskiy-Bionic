package bionic.pages;

import bionic.constants.SearchResults;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String readTitleOfFirstProductInNewProductsContainsRequest(String request) {
        String textOfFirstTitle = driver
                .findElements(SearchResults.TITLE)
                .get(0)
                .getText();

        return textOfFirstTitle;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
