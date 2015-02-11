package bionic.Lesson3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by c2612 on 11.02.2015.
 */
public class Discount {
    public static String readFile() {
        BufferedReader br = null;
        String resultString = "";

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("D:\\Selenium\\Burkivskiy-Bionic\\src\\test\\resources\\test.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                resultString += sCurrentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return resultString;
    }

}
