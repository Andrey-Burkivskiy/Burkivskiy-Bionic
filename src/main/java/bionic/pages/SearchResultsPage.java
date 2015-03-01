package bionic.pages;

import bionic.constants.SearchResults;
import bionic.support.Browser;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends AbstractPage {

    public SearchResultsPage(Browser window) {
        super(window);
    }
    
    public String readTitleOfFirstProductInNewProductsContainsRequest(String request) {
        String textOfFirstTitle = window
                .findElements(SearchResults.TITLE)
                .get(0)
                .getText();

        return textOfFirstTitle;
    }

    public Browser getWindow() {
        return window;
    }
}
