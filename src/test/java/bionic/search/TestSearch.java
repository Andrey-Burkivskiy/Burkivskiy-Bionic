package bionic.search;

import bionic.AbstractTest;
import bionic.data.SearchRequest;
import bionic.steps.UnregisteredUser;
import org.testng.annotations.*;


public class TestSearch extends AbstractTest {

    @Test
    public void testSearchOnHomePage() {
        UnregisteredUser user = new UnregisteredUser(window);
        user.searchFromHomePageByRequest(SearchRequest.REQUEST_WHITH_ONE_WORD);
        user.assertThatTitleOfFirstProductInNewProductsContainsRequest(SearchRequest.REQUEST_WHITH_ONE_WORD);
        returnDriverFrom(user);
    }
    
}
