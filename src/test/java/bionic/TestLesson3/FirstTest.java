package bionic.TestLesson3;

import bionic.Lesson3.NewClass;
import org.testng.annotations.Test;

/**
 * Created by c2612 on 11.02.2015.
 */
public class FirstTest {

    @Test
    public void testNewClass() {
        assert 4 == NewClass.someMethod(2, 2);
        assert 5 == NewClass.someMethod(3, 3);
    }
}
