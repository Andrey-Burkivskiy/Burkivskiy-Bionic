package bionic.TestLesson3;

import bionic.Lesson3.ReadTextFile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestReadTextFile {

    @Test
    public void testNewClass() {
        Assert.assertEquals(ReadTextFile.readFile(), "Hello world Hello world2");
    }
}
