package bionic;

/**
 * Created by c2612 on 04.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        String someString = "Some string";

        Encryption.decrypt(Encryption.encrypt(someString));
    }
}
