package bionic.TestHomeWork3;

import bionic.Lesson3.ReadTextFile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStringWithFloatNum {
    @Test
    public void testStringWithFloatNum() {
        String someString = ReadTextFile.readFile("file_home_work3.txt");
        Assert.assertEquals(someString.matches(".*( |^)(\\(?)[0-9]+\\.[0-9]+(\\)?)( |$).*"), true, "Real number does not found in string: \"" + someString +"\".");
    }
}
