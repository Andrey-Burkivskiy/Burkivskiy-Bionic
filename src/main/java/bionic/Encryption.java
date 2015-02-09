package bionic;

/**
 * Created by c2612 on 04.02.2015.
 */
public class Encryption {
    public static int[] encrypt(String str) {
        int[] arrChars = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            Integer tempChars = ((int) str.charAt(i));
            arrChars[i] = tempChars;
        }
        System.out.println("encrypt: ");
        for (int i = 0; i < str.length(); i++) {
            System.out.print(arrChars[i] + " ");
        }

        return arrChars;
    }

    public static String decrypt(int[] intChars) {
        String totalString = "";
        System.out.println();

        System.out.println("decrypt: ");

        for (int i = 0; i < intChars.length; i++) {
            int tempString = intChars[i];
            char tempCharacter = (char) tempString;

            totalString += tempCharacter;

        }
        System.out.println(totalString);
        return totalString;
    }
}
