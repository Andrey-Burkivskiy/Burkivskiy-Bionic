package bionic.TestLesson3;

import bionic.Lesson3.Discount;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void testNewClass() {
        Assert.assertEquals(Discount.readFile(), "Hello world");
    }
}
