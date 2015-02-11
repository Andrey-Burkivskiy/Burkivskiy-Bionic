package bionic.HomeWork2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchNumber {
    private static boolean isFind = false;
    private static int[] arr = GenerateArray.getArr();
    private static int lowIndex = 0;
    private static int highIndex = arr.length -1;

    public static void startSearch() {
        int indexOfNumber;
        while (!isFind) {
            System.out.println("Enter any number which you want to find in array:");
            try {
                Scanner userInput = new Scanner(System.in);
                indexOfNumber = startSearch(userInput.nextInt());
                if (indexOfNumber < 0) {
                    System.out.println("This number doesn't exist in array, try again:");
                } else {
                    System.out.println("Your number placed in cell #" + indexOfNumber);
                }
            } catch (InputMismatchException e) {
                System.out.println("You input not a number value:");
            }
        }
    }

    private static int startSearch(int val) {
        int low = lowIndex;
        int high = highIndex;

        while (low <= high) {
            int mid;
            if ((low + high) % 2 == 0) {
                mid = (low + high) / 2;
            } else {
                mid = ((low + high) /2) + 1;
            }

            int midVal = arr[mid];

            if (midVal < val) {
                low = mid + 1;
            }
            else if (midVal > val) {
                high = mid - 1;
            }
            else {
                isFind = true;
                return mid;
            }
        }
        return -(low + 1);
    }
}
