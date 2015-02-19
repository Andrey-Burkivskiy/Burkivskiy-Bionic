package bionic.search;

import bionic.data.SearchRequest;
import bionic.steps.UnregisteredUser;
import org.testng.annotations.*;


public class TestSearchOnHomePage {
    UnregisteredUser unregisteredUser;

    @Test
    public void testSearchOnHomePage() {
        unregisteredUser.searchFromHomePageByRequest(SearchRequest.REQUEST_WHITH_ONE_WORD);
        unregisteredUser.accertThatTitleOfFirstProductInNewProductsContainsRequest(SearchRequest.REQUEST_WHITH_ONE_WORD);
    }
    
    @BeforeSuite
    public void setUp() {
        unregisteredUser = new UnregisteredUser();
        unregisteredUser.openFireFox();
    }
    
    @AfterSuite
    public void clean() {
        unregisteredUser.closeBrouser();
    }
}
