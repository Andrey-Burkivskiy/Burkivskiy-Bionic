package bionic.data;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by andrey on 01.03.15.
 */
public class ProductData {
    public String id;
    
    public String titleText;
    public String titleErrorText;
    
    public String subCategoryOptionText;
    public By subCategoryOption;
    
    public String conditionOptionText;
    public By conditionOption;
    public String conditionErrorText;

    public String userTypeOptionText;
    public By userTypeOption;
    public String userTypeErrorText;
    
    public String regionOptionText;
    public By regionOption;

    public String townOptionText;
    public By townOption;
    public String townErrorText;

    public String descriptionText;
    public String descriptionErrorText;
    
    public String authorNameText;
    public String emailText;
    public String productType;
    public String priceText;
    public static String userType;
    public String pathToFirstImg;
    public boolean isChecked;

    public ProductData() {
        id = getRandomID();
        titleText = getRandomTitle();
        descriptionText = getRandomDescription();
        authorNameText = getRandomUserName();
        emailText = getRandomEmail();
        isChecked = true;
        pathToFirstImg = System.getProperty("user.dir") + "/src/test/resources/product_img.jpg";
        priceText = "Бесплатно";
        productType = "Аксессуары / запчасти";
        subCategoryOptionText = getRandomSubcategory();
        conditionOptionText = getRandomCondition();
        userTypeOptionText = "Частное лицо";
        regionOptionText = "Киевская область";
        townOptionText = getRandomTown();
        subCategoryOption = By.linkText(subCategoryOptionText);
        conditionOption = By.linkText(conditionOptionText);
        userTypeOption = By.linkText(userTypeOptionText);
        regionOption = By.linkText(regionOptionText);
        townOption = By.linkText(townOptionText);
    }
    
    public String getRandomTown() {
        Random random = new Random();
        List<String> town = new ArrayList<String>();
        town.add("Белая Церковь");
        town.add("Березань");
        town.add("Богуслав");
        town.add("Борисполь");
        town.add("Бородянка");
        town.add("Боярка");
        town.add("Бровары");
        town.add("Буча");
        town.add("Васильков");
        town.add("Вишнёвое");
        town.add("Володарка");
        town.add("Вышгород");
        town.add("Глеваха");
        town.add("Гостомель");
        town.add("Иванков");
        town.add("Ирпень");
        town.add("Кагарлык");
        town.add("Киев");
        town.add("Коцюбинское");
        town.add("Макаров");
        town.add("Мироновка");
        town.add("Обухов");
        town.add("Переяслав-Хмельницкий");
        town.add("Припять");
        town.add("Ракитное");
        town.add("Ржищев");
        town.add("Сквира");
        town.add("Славутич");
        town.add("Тараща");
        town.add("Тетиев");
        town.add("Узин");
        town.add("Украинка");
        town.add("Фастов");
        town.add("Чернобыль");
        town.add("Яготин");
        
        return town.get(random.nextInt(town.size()));
    }

    public String getRandomID() {
        Random random = new Random();
        return String.valueOf(random.nextInt(99999999));
    }
    
    public String getRandomSubcategory() {
        Random random = new Random();
        List<String> subCategory = new ArrayList<String>();

        subCategory.add("Аккумуляторы");
        subCategory.add("Зарядные устройства");
        subCategory.add("Гарнитуры");
        subCategory.add("Корпуса / панели");
        subCategory.add("Чехлы");
        subCategory.add("Data-кабели");
        subCategory.add("Прочие аксессуары для телефонов");
        
        return subCategory.get(random.nextInt(subCategory.size()));
    }


    public String getRandomEmail() {
        Random random = new Random();
        List<String> email = new ArrayList<String>();

        email.add("anton.vishnyakov@testmail.com");
        email.add("semen.komisarov@testmail.com");
        email.add("denis.vlasov@testmail.com");

        return email.get(random.nextInt(email.size()));
    }

    public String getRandomDescription() {
        return "Id: " + id + "Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo.";
    }


    public String getRandomTitle() {
        return "Продам батарею к Samsung GT-S3600i, S/N:" + id;
    }

    public String getRandomUserName() {
        Random random = new Random();
        List<String> userName = new ArrayList<String>();

        userName.add("Антон Вишаняков");
        userName.add("Семён Комисаров");
        userName.add("Денис Власов");

        return userName.get(random.nextInt(userName.size()));
    }

    public String getRegion() {
        return "Киевская область";
    }

    public String getRandomCondition() {
        
        Random random = new Random();
        List<String> condition = new ArrayList<String>();

        condition.add("Б/у");
        condition.add("Новый");

        return condition.get(random.nextInt(condition.size()));
    }

    /**
     * Negative data for title *
     * @return ProductData
     */

    public ProductData setShortTitle() {
        titleText = RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(1, 5)).toLowerCase();
        titleErrorText = "Заголовок должен быть не короче 5 знаков";
        return this;
    }

    public ProductData setEmptyTitle() {
        titleText = "";
        titleErrorText = "Пожалуйста, укажите заголовок";
        return this;
    }
    
    public ProductData setEmailInTitle() {
        titleText = RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(1, 8)).toLowerCase() + "@gmail.com";
        titleErrorText = "Поле заполнено неверно. Указание email или адреса сайта запрещено..";
        return this;
    }

    public ProductData setCepitalLetterInTitle() {
        titleText = RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(5, 8)).toUpperCase();
        titleErrorText = "Слишком много заглавных букв";
        return this;
    }

    public ProductData setLinkInTitle() {
        titleText = "http://" + RandomStringUtils.randomAlphabetic(9).toLowerCase() + ".com";
        titleErrorText = "Поле заполнено неверно. Указание email или адреса сайта запрещено..";
        return this;
    }

    /**
     * Negative data for description *
     * @return ProductData
     */
    
    public void setDescriptionValue(String text, String errorText) {
        descriptionText = text;
        descriptionErrorText = errorText;
    }
    
    public ProductData setEmptyDescription() {
        setDescriptionValue(
                "",
                "добавьте описание объявления"
        );
        return this;
    }

    public ProductData setShortDescription() {
        setDescriptionValue(
                RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(1, 50)).toLowerCase(),
                "Описание должно быть не короче 50 знаков"
                );
        return this;
    }

    public ProductData setEmptyCondition() {
        conditionOption = null;
        conditionErrorText = "Это поле нужно заполнить";
        return this;
    }

    public ProductData setEmptyUserType() {
        userTypeOption = null;
        userTypeErrorText = "Пожалуйста, укажите, это объявление от частного лица или от компании?";
        return this;
    }

    public ProductData setEmptyTown() {
        townOption = null;
        townErrorText = "Пожалуйста, укажите область и город";
        return this;
    }
}
