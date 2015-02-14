package bionic.Homework2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GenerateArray {
    private static int[] arr;

    public static void initArray() {
        System.out.println("Enter size of array, which you want build (accepts only integer number):");
        while (arr == null) {
            try {
                Scanner userInput = new Scanner(System.in);
                arr = new int[userInput.nextInt()];
            } catch (InputMismatchException e) {
                System.out.println("You input not a number value:");
            }
        }
    }

    public static void fillArray() {
        int counter = 0;
        while (counter < arr.length) {
            System.out.println("Enter value of cell #" + counter +  " (accepts only integer number):");
            try {
                Scanner userInput = new Scanner(System.in);
                arr[counter] = userInput.nextInt();
                counter++;
            } catch (InputMismatchException e) {
                System.out.println("You input not a number value:");
            }
        }
        sortArr();
    }

    private static void sortArr() {
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){

            if( arr[j] > arr[j+1] ){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
        }
        System.out.println("Your array was sorted, at now it look like:");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if( i != arr.length -1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] getArr() {
        return arr;
    }
}
