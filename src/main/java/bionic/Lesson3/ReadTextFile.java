package bionic.Lesson3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
    public static String readFile() {
        BufferedReader br = null;
        String resultString = "";

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/file_lesson3.txt"));

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
        resultString = resultString.substring(0, resultString.length() - 1);
        return resultString;
    }

    public static String readFile(String fileName) {
        BufferedReader br = null;
        String resultString = "";

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/" + fileName));

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
        resultString = resultString.substring(0, resultString.length() - 1);
        return resultString;
    }

}
