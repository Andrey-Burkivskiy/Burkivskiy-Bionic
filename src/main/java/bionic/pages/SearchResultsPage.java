package bionic.pages;

import bionic.constants.SearchResults;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends AbstractPage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    
    public String readTitleOfFirstProductInNewProductsContainsRequest(String request) {
        String textOfFirstTitle = driver
                .findElements(SearchResults.TITLE)
                .get(0)
                .getText();

        return textOfFirstTitle;
    }

    public Browser getDriver() {
        return driver;
    }
}
