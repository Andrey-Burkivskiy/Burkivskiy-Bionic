package bionic.steps;

import bionic.data.ProductData;
import bionic.pages.*;
import bionic.support.Browser;
import org.testng.Assert;

public class UnregisteredUser extends AbstractUser {


    public UnregisteredUser(Browser window) {
        super(window);
    }

    public void searchFromHomePageByRequest(String request) {
        HomePage home = new HomePage(window);
        
        home.openPage();
        home.searchByRequest(request);

        returnDriverFrom(home);
    }

    public void assertThatTitleOfFirstProductInNewProductsContainsRequest(String request) {
        SearchResultsPage searchResults = new SearchResultsPage(window);
        String titleOfFirstProduct = searchResults.readTitleOfFirstProductInNewProductsContainsRequest(request);
        String regExp = ".*(?i:" + request + ").*";
        String message = "Title of first (" + titleOfFirstProduct + ") product doesn't contains request: " + request;

        window = searchResults.getWindow();
        Assert.assertEquals(titleOfFirstProduct.matches(regExp), true, message);
    }


    public void openHomePage() {
        HomePage home = new HomePage(window);
        home.openPage();
        Assert.assertEquals(window.getCurrentUrl(), "http://olx.ua/");
        returnDriverFrom(home);
    }

    public void goToChildrensWorldCategory() {
        HomePage home = new HomePage(window);
        home.clickOnChildrensWorldCategory();
        returnDriverFrom(home);
        ChildrensWorldCategoryPage childrensWorldCategory = new ChildrensWorldCategoryPage(window);
        childrensWorldCategory.assertItIsChildrensWorldPage();
        returnDriverFrom(childrensWorldCategory);
    }
    
    public void selectFilterNewProducts() {
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(window);
        childrenWear.selectFilterNewProducts();
        returnDriverFrom(childrenWear);
    }
    
    public void openRandomProduct() {
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(window);
        childrenWear.chooseRandomProductFromList();
        String titleOfProductInListing = childrenWear.getTitleOfProduct();
        childrenWear.openRandomProductFromList();
        returnDriverFrom(childrenWear);
        SingleProductPage productPage = new SingleProductPage(window);
        Assert.assertEquals(titleOfProductInListing.toLowerCase(), productPage.getTitle().toLowerCase(), "Title on category page does not coincide with title on opened product page.");
        returnDriverFrom(productPage);
    }

    public void goToChildrensWearCategory() {
        ChildrensWorldCategoryPage chaild = new ChildrensWorldCategoryPage(window);
        chaild.clickOnCategoryChaildsWear();
        returnDriverFrom(chaild);
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(window);
        childrenWear.assertItIsChildrenWearPage();
        returnDriverFrom(childrenWear);
    }

    public void assertThatProductHasStateNew() {
        SingleProductPage productPage = new SingleProductPage(window);
        Assert.assertEquals(productPage.getProductStateLabel(), "Новый", "Opened product does not coincide with selected filter \"new\"");;
        returnDriverFrom(productPage);
    }

    public void openChildrensWearCategory() {
        ChildrenWearSubcategoryPage childrensWear = new ChildrenWearSubcategoryPage(window);
        childrensWear.openPage();
        returnDriverFrom(childrensWear);
    }

    public void setPriceLimits() {
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(window);
        childrenWear.setBottomPrice();
        childrenWear.setTopPrice();
        returnDriverFrom(childrenWear);
    }

    public void assertThatPriceOfProductOnFirstPageIsInFilterLimits() {
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(window);
        childrenWear.assertThatPriceOfProductOnFirstPageIsInFilterLimits();
        returnDriverFrom(childrenWear);
    }
    
    public void addProductWithRandomParameters() {
        AddProductPage addProductPage = new AddProductPage(window);
        addProductPage.openPage();
        addProductPage.inputProductTitle();
        addProductPage.selectTelephonePartsSubcategory();
        addProductPage.markRadioButtonFree();
        addProductPage.selectSubcategory();
        addProductPage.selectCondition();
        addProductPage.selectUserType();
        addProductPage.inputProductDescription();
        addProductPage.addImageToProduct();
        addProductPage.selectRegion();
        addProductPage.selectTown();
        addProductPage.inputAuthorName();
        addProductPage.inputEmail();
        addProductPage.markCheckboxAgreeWithRull();
        addProductPage.clickPreviewButton();
        returnDriverFrom(addProductPage);
    }
    
    public void assertThatAddedFildOfProductIsDisplayedCorrect() {
        PreviewProductPage previewProductPage = new PreviewProductPage(window);
        Assert.assertEquals(previewProductPage.getTitleText(), ProductData.titleText);
        Assert.assertEquals(previewProductPage.getProductTypeText(), ProductData.productType);
        Assert.assertEquals(previewProductPage.getPriceText(), ProductData.priceText);
        Assert.assertEquals(previewProductPage.getSubCategoryText(), ProductData.subCategoryOption);
        Assert.assertEquals(previewProductPage.getDescriptionText(), ProductData.descriptionText);
        Assert.assertEquals(previewProductPage.getMapPoint(), ProductData.townOption + ", " + ProductData.regionOption);
        Assert.assertEquals(previewProductPage.getAuthorNameText(), ProductData.authorNameText);
        Assert.assertEquals(previewProductPage.getPrivateText(), "Частного лица");
        Assert.assertEquals(previewProductPage.getConditionText(), ProductData.conditionOption);
        Assert.assertEquals(previewProductPage.getDescriptionText(), ProductData.descriptionText);
        Assert.assertEquals(previewProductPage.isImagePresent(), true, "Images, which were added to product, doesn't displayed in product view.");
        returnDriverFrom(previewProductPage);
    }
}
