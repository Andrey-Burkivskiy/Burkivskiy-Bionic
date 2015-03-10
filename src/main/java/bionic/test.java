package bionic;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;

import java.util.Random;

/**
 * Created by andrey on 08.03.15.
 */
public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(5, 8)));
        }
    }
}
