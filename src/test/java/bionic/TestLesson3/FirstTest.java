package bionic.TestLesson3;

import bionic.Lesson3.Discount;
import org.testng.annotations.Test;

/**
 * Created by c2612 on 11.02.2015.
 */
public class FirstTest {

    @Test
    public void testNewClass() {
        assert "Hello world".equals(Discount.readFile());
    }
}
