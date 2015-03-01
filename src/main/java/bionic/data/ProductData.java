package bionic.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by andrey on 01.03.15.
 */
public class ProductData {
    public static String id = "";
    public static String titleText = "";
    public static String subCategoryOption = "";
    public static String conditionOption = "";
    public static String regionOption = "";
    public static String townOption = "";

    public static String descriptionText = "";
    public static String authorNameText = "";
    public static String emailText = "";
    public static String productType = "Аксессуары / запчасти";
    public static String priceText = "Бесплатно";
    public static String privateOption = "Частное лицо";

    public static void generateData() {
        id = ProductData.getRandomID();
        titleText = ProductData.getRandomTitle();
        subCategoryOption = ProductData.getRandomSubcategory();
        conditionOption = ProductData.getRandomCondition();
        regionOption = ProductData.getRegion();
        townOption = ProductData.getRandomTown();
        descriptionText = ProductData.getRandomDescription();
        authorNameText = ProductData.getRandomUserName();
        emailText = ProductData.getRandomEmail();
    }

    public static String getRandomTown() {
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

    public static String getRandomID() {
        Random random = new Random();
        return String.valueOf(random.nextInt(99999999));
    }
    
    public static String getRandomSubcategory() {
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


    public static String getRandomEmail() {
        Random random = new Random();
        List<String> email = new ArrayList<String>();

        email.add("anton.vishnyakov@testmail.com");
        email.add("semen.komisarov@testmail.com");
        email.add("denis.vlasov@testmail.com");

        return email.get(random.nextInt(email.size()));
    }

    public static String getRandomDescription() {
        return "Id: " + id + "Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo.";
    }


    public static String getRandomTitle() {
        return "Продам батарею к Samsung GT-S3600i, S/N:" + id;
    }

    public static String getRandomUserName() {
        Random random = new Random();
        List<String> userName = new ArrayList<String>();

        userName.add("Антон Вишаняков");
        userName.add("Семён Комисаров");
        userName.add("Денис Власов");

        return userName.get(random.nextInt(userName.size()));
    }

    public static String getRegion() {
        return "Киевская область";
    }

    public static String getRandomCondition() {
        Random random = new Random();
        List<String> condition = new ArrayList<String>();

        condition.add("Б/у");
        condition.add("Новый");

        return condition.get(random.nextInt(condition.size()));
    }
}
