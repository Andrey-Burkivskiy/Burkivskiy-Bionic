package bionic.Homework2;

import java.util.*;

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
                    System.out.print("Your number found in next cells: ");
                    for (Integer number : searchAllCell(indexOfNumber))  {
                        System.out.print("#" + number + " ");
                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("You input not a integer number:");
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
    
    private static List<Integer> searchAllCell(int cellIndex) {
        List<Integer> cellsNumber = new ArrayList<Integer>();
        int descendingIndex = cellIndex - 1;
        int ascendingIndex = cellIndex;

            while(descendingIndex >= 0 && arr[cellIndex] == arr[descendingIndex]) {
                cellsNumber.add(descendingIndex);
                descendingIndex--;
            }

            while(ascendingIndex < arr.length && arr[cellIndex] == arr[ascendingIndex]) {
                cellsNumber.add(ascendingIndex);
                ascendingIndex++;
            }
        Collections.sort(cellsNumber);
        return cellsNumber;
    }
}
