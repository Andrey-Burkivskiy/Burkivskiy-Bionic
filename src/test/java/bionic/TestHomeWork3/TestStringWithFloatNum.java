package bionic.TestHomeWork3;

import bionic.Lesson3.ReadTextFile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStringWithFloatNum {
    @Test
    public void testStringWithFloatNum() {
        String stringFromFile = ReadTextFile.readFile("file_homework3.txt");
        Assert.assertEquals(stringFromFile.matches(".*( |^)(\\(?)[0-9]+\\.[0-9]+(\\)?)( |$).*"), true, "Real number does not found in string: \"" + stringFromFile +"\".");
    }
}
