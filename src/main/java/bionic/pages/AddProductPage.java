package bionic.pages;

import bionic.data.ProductData;
import bionic.support.Browser;
import org.openqa.selenium.By;

/**
 * Created by andrey on 01.03.15.
 */
public class AddProductPage extends AbstractPage {


    public AddProductPage(Browser window) {
        super(window);
    }

    public static final String URL = HomePage.URL + "/post-new-ad/";
    
    private final String PATH_TO_FIRST_IMG = System.getProperty("user.dir") + "/src/test/resources/product_img.jpg";

    private final By TITLE_FIELD = By.cssSelector("#add-title");
    private final By OPEN_CATEGORY_LIST_BUTTON = By.cssSelector("dt > a");
    private final By ELECTRONIC_CATEGORY = By.xpath("//a[@id='cat-37']/span[2]/strong");
    private final By TELEPHONE_SUB_CATEGORY = By.xpath("//div[@id='category-37']/div[2]/div[2]/div/ul/li/a/span");
    private final By PARTS_SUB_CATEGORY = By.xpath("//div[@id='category-44']/div[2]/div[2]/div/ul/li/a/span");
    private final By PRICE_FREE_RADIO_BUTTON = By.xpath("//div[@id='parameter-div-price']/div[2]/div/div/p/label");
    private final By SUB_CATEGORY_BUTTON = By.cssSelector("#targetparam17 > dt > a");
    private final By SUB_CATEGORY_OPTION = By.linkText(ProductData.subCategoryOption);
    private final By CONDITION_BUTTON = By.cssSelector("#targetparam13 > dt > a");
    private final By CONDITION_OPTION = By.linkText(ProductData.conditionOption);
    private final By USER_TYPE_BUTTON = By.cssSelector("#targetid_private_business > dt > a");
    private final By PRIVATE_OPTION = By.linkText(ProductData.privateOption);
    private final By DESCRIPTION_FIELD = By.id("add-description");
    private final By ALT_IMAGE_VIEW_BUTTON = By.id("show-gallery-html");
    private final By ADD_FIRST_IMG_FIELD = By.xpath(".//*[@id='htmlbutton_2']/input");
    private final By REGION_BUTTON = By.cssSelector("#targetregion-id-select > dt > a");
    private final By REGION_OPTION = By.linkText(ProductData.regionOption);
    private final By TOWN_BUTTON = By.cssSelector("#targetsubregion-id-select > dt > a");
    private final By TOWN_OPTION = By.linkText(ProductData.townOption);
    private final By NAME_FIELD = By.id("add-person");
    private final By EMAIL_FIELD = By.id("add-email");
    private final By AGREE_WITH_RULES_CHECKBOX = By.xpath(".//*[@id='accept']//label[@relname='data[accept]']");
    private final By PREVIEW_ORDER_BUTTON = By.id("preview-link");

    static {
        ProductData.generateData();
    }


    public void openPage() {
        window.get(URL);
    }

    public void inputProductTitle() {
        window.findElement(TITLE_FIELD).clear();
        window.findElement(TITLE_FIELD).sendKeys(ProductData.titleText);
    }

    public void selectTeleponePartsSubcategory() {
        window.findElement(OPEN_CATEGORY_LIST_BUTTON).click();
        window.findElement(ELECTRONIC_CATEGORY).click();
        window.findElement(TELEPHONE_SUB_CATEGORY).click();
        window.findElement(PARTS_SUB_CATEGORY).click();
    }

    public void markRadiobuttonFree() {
        window.findElement(PRICE_FREE_RADIO_BUTTON).click();
    }

    public void selectSubcategory() {
        window.findElement(SUB_CATEGORY_BUTTON).click();
        window.findElement(SUB_CATEGORY_OPTION).click();
    }

    public void selectCondition() {
        window.findElement(CONDITION_BUTTON).click();
        window.findElement(CONDITION_OPTION).click();
    }

    public void selectUserType() {
        window.findElement(USER_TYPE_BUTTON).click();
        window.findElement(PRIVATE_OPTION).click();
    }

    public void inputProductDescription() {
        window.findElement(DESCRIPTION_FIELD).clear();
        window.findElement(DESCRIPTION_FIELD).sendKeys(ProductData.descriptionText);
    }
    
    public void addImageToProduct() {
        window.findElement(ALT_IMAGE_VIEW_BUTTON).click();
        window.findElement(ADD_FIRST_IMG_FIELD).sendKeys(PATH_TO_FIRST_IMG);
    }

    public void selectRegion() {
        window.findElement(REGION_BUTTON).click();
        window.findElement(REGION_OPTION).click();
    }

    public void selectTown() {
        window.findElement(TOWN_BUTTON).click();
        window.findElement(TOWN_OPTION).click();
    }

    public void inputAuthorName() {
        window.findElement(NAME_FIELD).clear();
        window.findElement(NAME_FIELD).sendKeys(ProductData.authorNameText);
    }

    public void inputEmail() {
        window.findElement(EMAIL_FIELD).clear();
        window.findElement(EMAIL_FIELD).sendKeys(ProductData.emailText);
    }

    public void markCheckboxAgreeWithRull() {
        window.findElement(AGREE_WITH_RULES_CHECKBOX).click();
    }

    public void clickPreviewButton() {
        window.findElement(PREVIEW_ORDER_BUTTON).click();
    }

}
