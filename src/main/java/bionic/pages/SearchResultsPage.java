package bionic.pages;

import bionic.webDriver.Browser;
import org.openqa.selenium.By;

public class SearchResultsPage extends AbstractPage {

    public SearchResultsPage(Browser window) {
        super(window);
    }
    
    private final By TITLE = By.cssSelector("h3>a>span");
    
    public String readTitleOfFirstProductInNewProductsContainsRequest(String request) {
        String textOfFirstTitle = window
                .findElements(TITLE)
                .get(0)
                .getText();

        return textOfFirstTitle;
    }

    public Browser getWindow() {
        return window;
    }
}
