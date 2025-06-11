// Given an array, we have to find the largest element in the array.

import java.util.Arrays;
import java.util.Scanner;

public class LargestNumber {

    // Sorting approach
    /*
     * Time complexity - O(NlogN)
     * Space complexity - O(n)
     */
    public static void approach2(int[] arr, int n) {
        // sorting - selection sort -> O(n^2)
        // for (int i = 0; i < n; i++) {
        // int min = i;
        // for (int j = i+1; j < n; j++) {
        // if(arr[j]<arr[min]) min = j;
        // }
        // int temp = arr[i];
        // arr[i] = arr[min];
        // arr[min] = temp;
        // }

        Arrays.sort(arr); // O(nlogn)

        // Largest element at the last
        System.out.println("Largest Element : " + arr[n - 1]);
    }

    // Recursive approach
    /*
     * Time complexity - O(N)
     * Space complexity - O(1)
     */
    public static void approach1(int[] arr, int n) {
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("Largest Element : " + max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements in array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        approach2(arr, n);
        sc.close();
    }
}