package bionic.pages;

import bionic.data.ProductData;
import bionic.webDriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by andrey on 01.03.15.
 */
public class AddProductPage extends AbstractPage {



    public AddProductPage(Browser window) {
        super(window);
    }
    
    private ProductData productData;
    
    public static final String URL = HomePage.URL + "/post-new-ad/";
    

    private By TITLE_FIELD = By.id("add-title");
    private By TITLE_ERROR_TEXT = By.cssSelector("label.error[for='add-title']");
    
    private By OPEN_CATEGORY_LIST_BUTTON = By.cssSelector("#targetrenderSelect1-0>dt>a");
    private By ELECTRONIC_CATEGORY = By.xpath(".//a[@id='cat-37']/span[2]/strong");
    private By TELEPHONE_SUB_CATEGORY = By.xpath(".//div[@id='category-37']/div[2]/div[2]/div/ul/li/a/span");
    private By PARTS_SUB_CATEGORY = By.xpath(".//div[@id='category-44']/div[2]/div[2]/div/ul/li/a/span");
    private By PRICE_FREE_RADIO_BUTTON = By.cssSelector("label[for='parameter-free'].icon");
    private By SUB_CATEGORY_BUTTON = By.cssSelector("#targetparam17>dt> a");
    private By SUB_CATEGORY_OPTION;

    private By CONDITION_BUTTON = By.cssSelector("#targetparam13>dt>a");
    private By CONDITION_OPTION;
    private By CONDITION_ERROR_TEXT = By.cssSelector("label.error[for='param13']");

    private By USER_TYPE_BUTTON = By.cssSelector("#targetid_private_business > dt > a");
    private By USER_TYPE_OPTION;
    private By USER_TYPE_ERROR_TEXT = By.cssSelector("label.error[for='id_private_business']");

    private By DESCRIPTION_FIELD = By.id("add-description");
    private By DESCRIPTION_ERROR_TEXT = By.cssSelector("label.error[for='add-description']");

    private By ALT_IMAGE_VIEW_BUTTON = By.id("show-gallery-html");
    private By ADD_FIRST_IMG_FIELD = By.xpath(".//*[@id='htmlbutton_2']/input");
    private By REGION_BUTTON = By.cssSelector("#targetregion-id-select > dt > a");
    private By REGION_OPTION;

    private By TOWN_BUTTON = By.cssSelector("#targetsubregion-id-select > dt > a");
    private By TOWN_OPTION;
    private By TOWN_ERROR_TEXT = By.cssSelector("label.error[for='subregion-id-select']");

    private By NAME_FIELD = By.id("add-person");
    private By EMAIL_FIELD = By.id("add-email");
    private By AGREE_WITH_RULES_CHECKBOX = By.xpath(".//*[@id='accept']//label[@relname='data[accept]']");
    private By PREVIEW_ORDER_BUTTON = By.id("preview-link");
    
    private By SPINNER = By.id("fancybox-loading");

    public void openPage() {
        window.get(URL);
        selectRussianLang();
    }
    
    public void setProductData(ProductData productData) {
        this.productData = productData;
        SUB_CATEGORY_OPTION = productData.subCategoryOption;
        CONDITION_OPTION = productData.conditionOption;
        USER_TYPE_OPTION = productData.userTypeOption;
        REGION_OPTION = productData.regionOption;
        TOWN_OPTION = productData.townOption;
    }

    public void inputProductTitle() {
        window.findElement(TITLE_FIELD).clear();
        window.findElement(TITLE_FIELD).sendKeys(productData.titleText);
    }

    public void selectTelephonePartsSubcategory() {
        window.findElement(OPEN_CATEGORY_LIST_BUTTON).click();
        window.findElement(ELECTRONIC_CATEGORY).click();
        window.findElement(TELEPHONE_SUB_CATEGORY).click();
        window.findElement(PARTS_SUB_CATEGORY).click();
    }

    public void markRadioButtonFree() {
        WebDriverWait wait = new WebDriverWait(window.driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(SPINNER));
        window.findElement(PRICE_FREE_RADIO_BUTTON).click();
    }

    public void selectSubcategory() {
        if (SUB_CATEGORY_OPTION != null) {
            window.findElement(SUB_CATEGORY_BUTTON).click();
            window.findElement(SUB_CATEGORY_OPTION).click();
        }
    }

    public void selectCondition() {
        if (CONDITION_OPTION != null) {
            window.findElement(CONDITION_BUTTON).click();
            window.findElement(CONDITION_OPTION).click();
        }
    }

    public void selectUserType() {
        if (USER_TYPE_OPTION!= null) {
            window.findElement(USER_TYPE_BUTTON).click();
            window.findElement(USER_TYPE_OPTION).click();
        }
    }

    public void inputProductDescription() {
            window.findElement(DESCRIPTION_FIELD).clear();
            window.findElement(DESCRIPTION_FIELD).sendKeys(productData.descriptionText);
    }
    
    public void addImageToProduct() {
        window.findElement(ALT_IMAGE_VIEW_BUTTON).click();
        window.findElement(ADD_FIRST_IMG_FIELD).sendKeys(productData.pathToFirstImg);
    }

    public void selectRegion() {
        if (REGION_OPTION != null) {
            window.findElement(REGION_BUTTON).click();
            window.findElement(REGION_OPTION).click();
        }
    }

    public void selectTown() {
        if (TOWN_OPTION != null) {
            window.findElement(TOWN_BUTTON).click();
            window.findElement(TOWN_OPTION).click();
        }
    }

    public void inputAuthorName() {
        window.findElement(NAME_FIELD).clear();
        window.findElement(NAME_FIELD).sendKeys(productData.authorNameText);
    }

    public void inputEmail() {
        window.findElement(EMAIL_FIELD).clear();
        window.findElement(EMAIL_FIELD).sendKeys(productData.emailText);
    }

    public void markCheckboxAgreeWithRules() {
        if (productData.isChecked) {
            window.findElement(AGREE_WITH_RULES_CHECKBOX).click();
        }
    }
    
    public String getTitleErrorMessageText() {
        return window.findElement(TITLE_ERROR_TEXT).getText();
    }

    public String getDescriptionErrorMessageText() {
        return window.findElement(DESCRIPTION_ERROR_TEXT).getText();
    }
    
    public String getConditionErrorMessageText() {
        return window.findElement(CONDITION_ERROR_TEXT).getText();
    }
    
    public String getUserTypeErrorMessageText() {
        return window.findElement(USER_TYPE_ERROR_TEXT).getText();
    }
    
    public String getTownErrorMessageText() {
        return window.findElement(TOWN_ERROR_TEXT).getText();
    }
    
    public void clickPreviewButton() {
        window.findElement(PREVIEW_ORDER_BUTTON).click();
    }

    public ProductData getProductData() {
        return productData;
    }

}
