package bionic.steps;

import bionic.constants.Settings;
import bionic.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class UnregisteredUser extends AbstractUser {


    public UnregisteredUser(WebDriver driver) {
        super(driver);
    }

    public void searchFromHomePageByRequest(String request) {
        HomePage home = new HomePage(driver);
        
        home.openPage();
        home.searchByRequest(request);

        returnDriverFrom(home);
    }

    public void assertThatTitleOfFirstProductInNewProductsContainsRequest(String request) {
        SearchResultsPage searchResults = new SearchResultsPage(driver);
        String titleOfFirstProduct = searchResults.readTitleOfFirstProductInNewProductsContainsRequest(request);
        String regExp = ".*(?i:" + request + ").*";
        String message = "Title of first (" + titleOfFirstProduct + ") product doesn't contains request: " + request;

        driver = searchResults.getDriver();
        Assert.assertEquals(titleOfFirstProduct.matches(regExp), true, message);
    }


    public void openHomePage() {
        HomePage home = new HomePage(driver);
        home.openPage();
        Assert.assertEquals(driver.getCurrentUrl(), "http://olx.ua/");
        returnDriverFrom(home);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void goToChildrensWorldCategory() {
        HomePage home = new HomePage(driver);
        home.clickOnChildrensWorldCategory();
        returnDriverFrom(home);
        ChildrensWorldCategoryPage childrensWorldCategory = new ChildrensWorldCategoryPage(driver);
        childrensWorldCategory.assertItIsChildrensWorldPage();
        returnDriverFrom(childrensWorldCategory);
    }
    
    public void selectFilterNewProducts() {
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(driver);
        childrenWear.selectFilterNewProducts();
        returnDriverFrom(childrenWear);
    }
    
    public void openRandomProduct() {
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(driver);
        childrenWear.chooseRandomProductFromList();
        String titleOfProductInListing = childrenWear.getTitleOfProduct();
        childrenWear.openRundomProductFromList();
        returnDriverFrom(childrenWear);
        SingleProductPage productPage = new SingleProductPage(driver);
        Assert.assertEquals(titleOfProductInListing.toLowerCase(), productPage.getTitle().toLowerCase(), "Title on category page does not coincide with title on opened product page.");
        returnDriverFrom(productPage);
    }

    public void goToChildrensWearCategory() {
        ChildrensWorldCategoryPage chaild = new ChildrensWorldCategoryPage(driver);
        chaild.clickOnCategoryChaildsWear();
        returnDriverFrom(chaild);
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(driver);
        childrenWear.assertItIsChildrenWearPage();
        returnDriverFrom(childrenWear);
    }

    public void assertThatProductHasStateNew() {
        SingleProductPage productPage = new SingleProductPage(driver);
        Assert.assertEquals(productPage.getProductStateLabel(), "Новый", "Opened product does not coincide with selected filter \"new\"");;
        returnDriverFrom(productPage);
    }

    public void openChildrensWearCategory() {
        ChildrenWearSubcategoryPage childrensWear = new ChildrenWearSubcategoryPage(driver);
        childrensWear.openPage();
        returnDriverFrom(childrensWear);
    }

    public void setPriceLimits() {
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(driver);
        childrenWear.setBottomPrice();
        childrenWear.setTopPrice();
        returnDriverFrom(childrenWear);
    }

    public void assertThatPriceOfProductOnFirstPageIsInFilterLimits() {
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(driver);
        childrenWear.assertThatPriceOfProductOnFirstPageIsInFilterLimits();
        returnDriverFrom(childrenWear);
    }
}
