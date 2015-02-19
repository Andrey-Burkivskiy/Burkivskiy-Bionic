package bionic.TestLesson4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRealNumberInString {

    @Test
    public void testReadCreatedTextFile() {
        String string = "some string1324.234";
        Assert.assertEquals(string.matches(".*[0-9]+\\.[0-9]+.*"), true, "Real number does not found in string: \"" + string + "\".");
    }
}
