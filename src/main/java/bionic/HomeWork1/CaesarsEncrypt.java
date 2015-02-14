package bionic.Homework1;

import java.util.Scanner;

public class CaesarsEncrypt {
    public static void main(String[] args) {
        System.out.println("Enter your string for encryption:");
        Scanner scanner = new Scanner(System.in);
        String encryptString = scanner.nextLine();
        System.out.println("Your string was encrypted, you can look at result:");
        System.out.println(Encryption.encrypt(encryptString));
        System.out.println("Enter your string for decryption:");
        String decryptString = scanner.nextLine();
        System.out.println("Your string was encrypted, you can look at result:");
        System.out.println(Encryption.decrypt(decryptString));
    }
}
