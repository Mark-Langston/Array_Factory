// CSC262 Programming in JAVA
// Mark Langston    5/25/2024
import java.util.Scanner;

public class Main {

    // Calculates the array sum minus the largest value
    public static int sumWithoutLargest(int[] arr) {
        if (arr.length == 0) return 0;

        int largest = arr[0];
        int sum = 0;
        int largestCount = 0;

        // Finds the largest number in the array
        for (int value : arr) {
            if (value > largest) {
                largest = value;
                largestCount = 1;
            } else if (value == largest) {
                largestCount++;
            }
            sum += value;
        }

        // Subtracts the largest value from the sum of the array
        return sum - largest;
    }

    // Creates a second array that does not include the largest value
    public static int[] arrayWithoutLargest(int[] arr) {
        int largest = arr[0];
        int largestCount = 0;

        // Finds the largest value in the array
        for (int value : arr) {
            if (value > largest) {
                largest = value;
                largestCount = 1;
            } else if (value == largest) {
                largestCount++;
            }
        }

        // Creates the new array
        int[] newArr = new int[arr.length - largestCount];
        int index = 0;
        for (int value : arr) {
            if (value != largest) {
                newArr[index++] = value;
            }
        }

        return newArr;
    }

    // Swaps the smallest and largest number in the array
    public static void swapLargestSmallest(int[] arr) {
        if (arr.length < 2) return;

        int largest = arr[0], smallest = arr[0];
        int largestIndex = 0, smallestIndex = 0;

        // Finds the index of the smallest and largest value
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
                largestIndex = i;
            } else if (arr[i] < smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
        }

        // Swaps the smallest and largest value index
        int temp = arr[largestIndex];
        arr[largestIndex] = arr[smallestIndex];
        arr[smallestIndex] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompts user for size of array and values
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array values (integers only):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Calls sumWithoutLargest method
        int sumWithoutLargest = sumWithoutLargest(arr);
        System.out.println("Sum without largest element: " + sumWithoutLargest);

        // Calls arrWithoutLargest method
        int[] arrWithoutLargest = arrayWithoutLargest(arr);
        System.out.print("Array after sumWithoutLargest: ");
        printArray(arrWithoutLargest);

        // Calls swapLargestSmallest method
        swapLargestSmallest(arr);
        System.out.println("Array after swapLargestSmallest: ");
        printArray(arr);
    }

    // Prints array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
