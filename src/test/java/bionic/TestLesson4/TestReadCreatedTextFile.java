package bionic.TestLesson4;

import bionic.Lesson3.ReadTextFile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class TestReadCreatedTextFile {
    private static File file;

    @Test
    public void testReadCreatedTextFile() {
        String stringFromFile = ReadTextFile.readFile("file_lesson4.txt");
        Assert.assertEquals(stringFromFile.matches(".*( |^)(\\(?)[0-9]+\\.[0-9]+(\\)?)( |$).*"), true, "Real number does not found in string: \"" + stringFromFile + "\".");

    }

    @BeforeTest
    public void createFile() {
        String path = System.getProperty("user.dir") + "/src/test/resources/file_lesson4.txt";
        write(path, "some string with natural number: 98134.234243 and some text");
    }

    @AfterTest
    public void deleteFile() {
        try {
            delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void write(String fileName, String text) {
        //Определяем файл
        file = new File(fileName);

        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                out.print(text);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete() throws FileNotFoundException {
        file.delete();
    }
}
