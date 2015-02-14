package bionic.HomeWork1;

public class Encryption {
    public static int key = 3;

    public static String encrypt(String someString) {
        char[] arrChar = someString.toCharArray();
        char[] resultArrChar = new char[arrChar.length];
        String resultString = "";

        for (int i = 0; i < arrChar.length; i++) {
            int tempCodeChar = (int) arrChar[i];
            tempCodeChar += key;
            resultArrChar[i] = (char) tempCodeChar;
        }

        for (int currentChar : resultArrChar) {
            resultString += currentChar;
        }

        return resultString;
    }

    public static String decrypt(String someString) {
        char[] arrChar = someString.toCharArray();
        char[] resultArrChar = new char[arrChar.length];
        String resultString = "";

        for (int i = 0; i < arrChar.length; i++) {
            int tempCodeChar = (int) arrChar[i];
            tempCodeChar -= key;
            resultArrChar[i] = (char) tempCodeChar;
        }

        for (int currentChar : resultArrChar) {
            resultString += currentChar;
        }

        return resultString;
    }
}
