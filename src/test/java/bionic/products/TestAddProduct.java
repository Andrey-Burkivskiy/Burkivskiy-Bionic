package bionic.products;

import bionic.AbstractTest;
import bionic.data.ProductData;
import bionic.steps.UnregisteredUser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by andrey on 28.02.15.
 */
public class TestAddProduct extends AbstractTest {
    @DataProvider(name = "Incorrect title")
    public static Object[][] incorrectTitles() {
        return new Object[][]{
                {new ProductData().setShortTitle()},
                {new ProductData().setEmptyTitle()},
                {new ProductData().setEmailInTitle()},
                {new ProductData().setCepitalLetterInTitle()},
                {new ProductData().setLinkInTitle()},
        };
    }
    
    @DataProvider(name = "Incorrect description")
    public static Object[][] incorrectDescription() {
        return new Object[][]{
                {new ProductData().setEmptyDescription()},
                {new ProductData().setShortDescription()},
        };
    }
    
    @Test
    public void testAddValidProduct() {
        UnregisteredUser user = new UnregisteredUser(window);
        user.setProductData(new ProductData());
        user.addProductWithRandomParameters();
        user.assertThatAddedFildOfProductIsDisplayedCorrect();
        returnDriverFrom(user);
    }
    
    @Test(dataProvider = "Incorrect title")
    public void testAddProductWithIncorrectTitle(ProductData data) {
        UnregisteredUser user = new UnregisteredUser(window);
        user.setProductData(data);
        user.addProductWithWrongTitle();
        returnDriverFrom(user);

    }
    
    @Test(dataProvider = "Incorrect description")
    public void testAddProductWithIncorrectDescription(ProductData data){
        UnregisteredUser user = new UnregisteredUser(window);
        user.setProductData(data);
        user.addProductWithWrongDescription();
        returnDriverFrom(user);
    }
    
    @Test
    public void testAddProductWithoutCondition() {
        UnregisteredUser user = new UnregisteredUser(window);
        user.setProductData(new ProductData().setEmptyCondition());
        user.addProductWithWrongCondition();
        returnDriverFrom(user);
    }
    
    @Test
    public void testAddProductWithoutUserType() {
        UnregisteredUser user = new UnregisteredUser(window);
        user.setProductData(new ProductData().setEmptyUserType());
        user.addProductWithWrongUserType();
        returnDriverFrom(user);
    }

    @Test
    public void testAddProductWithoutTown() {
        UnregisteredUser user = new UnregisteredUser(window);
        user.setProductData(new ProductData().setEmptyTown());
        user.addProductWithWrongTown();
        returnDriverFrom(user);
    }

}
