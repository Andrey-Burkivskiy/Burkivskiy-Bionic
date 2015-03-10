package bionic.steps;

import bionic.data.ProductData;
import bionic.pages.*;
import bionic.webDriver.Browser;
import org.slf4j.*;
import org.testng.Assert;


public class UnregisteredUser extends AbstractUser {
    
    ProductData productData;
    
    Logger logger = LoggerFactory.getLogger(UnregisteredUser.class);


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
        logger.info("Open home page.");
        returnDriverFrom(home);
    }

    public void goToChildrensWorldCategory() {
        HomePage home = new HomePage(window);
        home.clickOnChildrensWorldCategory();
        returnDriverFrom(home);
        ChildrensWorldCategoryPage childrensWorldCategory = new ChildrensWorldCategoryPage(window);
        childrensWorldCategory.assertItIsChildrensWorldPage();
        logger.info("Children's world category is opened.");
        returnDriverFrom(childrensWorldCategory);
    }
    
    public void selectFilterNewProducts() {
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(window);
        childrenWear.selectFilterNewProducts();
        logger.info("Selected filter new.");
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
        logger.info("Title of random product is equal to text on clicked link");
        returnDriverFrom(productPage);
    }

    public void goToChildrensWearCategory() {
        ChildrensWorldCategoryPage chaild = new ChildrensWorldCategoryPage(window);
        chaild.clickOnCategoryChaildsWear();
        returnDriverFrom(chaild);
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(window);
        childrenWear.assertItIsChildrenWearPage();
        logger.info("Children's wear category is open.");
        returnDriverFrom(childrenWear);
    }

    public void assertThatProductHasStateNew() {
        SingleProductPage productPage = new SingleProductPage(window);
        Assert.assertEquals(productPage.getProductStateLabel(), "Новый", "Opened product does not coincide with selected filter \"new\"");;
        logger.info("Opened product coincide with selected filter new.");
        returnDriverFrom(productPage);
    }

    public void openChildrensWearCategory() {
        ChildrenWearSubcategoryPage childrensWear = new ChildrenWearSubcategoryPage(window);
        childrensWear.openPage();
        childrensWear.assertItIsChildrenWearPage();
        logger.info("Children's wear category is open.");
        returnDriverFrom(childrensWear);
    }

    public void setPriceLimits() {
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(window);
        childrenWear.setBottomPrice();
        childrenWear.setTopPrice();
        logger.info("Filters are set.");
        returnDriverFrom(childrenWear);
    }

    public void assertThatPriceOfProductOnFirstPageIsInFilterLimits() {
        ChildrenWearSubcategoryPage childrenWear = new ChildrenWearSubcategoryPage(window);
        childrenWear.assertThatPriceOfProductOnFirstPageIsInFilterLimits();
        logger.info("Price of product is in filter limits");
        returnDriverFrom(childrenWear);
    }
    
    public void setProductData(ProductData productData) {
        this.productData = productData;
        logger.info("Product data is set.");
    }
    
    public void addProductUsingData() {
        AddProductPage addProductPage = new AddProductPage(window);
        addProductPage.setProductData(productData);
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
        addProductPage.markCheckboxAgreeWithRules();
        addProductPage.clickPreviewButton();
        this.productData = addProductPage.getProductData();
        logger.info("Product added");
        returnDriverFrom(addProductPage);
    }
    
    public void addProductWithRandomParameters() {
        addProductUsingData();
        PreviewProductPage previewProductPage = new PreviewProductPage(window);
        Assert.assertEquals(previewProductPage.getTitleText(), productData.titleText);
        logger.info("Product with random parameters was added.");
        returnDriverFrom(previewProductPage);
    }
    
    public void assertThatAddedFildOfProductIsDisplayedCorrect() {
        PreviewProductPage previewProductPage = new PreviewProductPage(window);
        Assert.assertEquals(previewProductPage.getTitleText(), productData.titleText);
        Assert.assertEquals(previewProductPage.getProductTypeText(), productData.productType);
        Assert.assertEquals(previewProductPage.getPriceText(), productData.priceText);
        Assert.assertEquals(previewProductPage.getSubCategoryText(), productData.subCategoryOptionText);
        Assert.assertEquals(previewProductPage.getDescriptionText(), productData.descriptionText);
        Assert.assertEquals(previewProductPage.getMapPoint(), productData.townOptionText + ", " + productData.regionOptionText);
        Assert.assertEquals(previewProductPage.getAuthorNameText(), productData.authorNameText);
        Assert.assertEquals(previewProductPage.getPrivateText(), "Частного лица");
        Assert.assertEquals(previewProductPage.getConditionText(), productData.conditionOptionText);
        Assert.assertEquals(previewProductPage.getDescriptionText(), productData.descriptionText);
        Assert.assertEquals(previewProductPage.isImagePresent(), true, "Images, which were added to product, doesn't displayed in product view.");
        logger.info("All fields of product is displayed according to inputed value.");
        returnDriverFrom(previewProductPage);
    }

    public void addProductWithWrongTitle() {
        addProductUsingData();
        AddProductPage addProductPage = new AddProductPage(window);
        Assert.assertEquals(addProductPage.getTitleErrorMessageText(), productData.titleErrorText);
        logger.info("Appear title error massage equal to: " + productData.titleErrorText);
        returnDriverFrom(addProductPage);
    }

    public void addProductWithWrongDescription() {
        addProductUsingData();
        AddProductPage addProductPage = new AddProductPage(window);
        Assert.assertEquals(addProductPage.getDescriptionErrorMessageText(), productData.descriptionErrorText);
        logger.info("Appear description error massage equal to: " + productData.descriptionErrorText);
        returnDriverFrom(addProductPage);
    }

    public void addProductWithWrongCondition() {
        addProductUsingData();
        AddProductPage addProductPage = new AddProductPage(window);
        Assert.assertEquals(addProductPage.getConditionErrorMessageText(), productData.conditionErrorText);
        logger.info("Appear condition error massage equal to: " + productData.conditionErrorText);
        returnDriverFrom(addProductPage);
    }

    public void addProductWithWrongUserType() {
        addProductUsingData();
        AddProductPage addProductPage = new AddProductPage(window);
        Assert.assertEquals(addProductPage.getUserTypeErrorMessageText(), productData.userTypeErrorText);
        logger.info("Appear user type error massage equal to: " + productData.userTypeErrorText);
        returnDriverFrom(addProductPage);
    }

    public void addProductWithWrongTown() {
        addProductUsingData();
        AddProductPage addProductPage = new AddProductPage(window);
        Assert.assertEquals(addProductPage.getTownErrorMessageText(), productData.townErrorText);
        logger.info("Appear town error massage equal to: " + productData.townErrorText);
        returnDriverFrom(addProductPage);
    }
}
