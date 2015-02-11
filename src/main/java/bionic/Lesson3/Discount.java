package bionic.Lesson3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Discount {
    public static String readFile() {
        BufferedReader br = null;
        String resultString = "";

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/test.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                resultString += sCurrentLine + " ";
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
