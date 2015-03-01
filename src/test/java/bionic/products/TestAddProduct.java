package bionic.products;

import bionic.AbstractTest;
import bionic.steps.UnregisteredUser;
import org.testng.annotations.Test;

/**
 * Created by andrey on 28.02.15.
 */
public class TestAddProduct extends AbstractTest {
    @Test
    public void testAddValidProduct() {
        UnregisteredUser user = new UnregisteredUser(window);
        user.addProductWithRandomParameters();
        user.assertThatAddedFildOfProductIsDisplayedCorrect();
    }

}
