// Given an array of size n, write a program to check if the given array is sorted in 
// (ascending / Increasing / Non-decreasing) order or not. 
// If the array is sorted then return True, Else return False.

import java.util.Scanner;

public class CheckAscendingSorting {

    // Brute Force Approach -- checking all element in the right to be greater.
    /*
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public static void approach1(int[] arr, int n) {

        boolean sorted_flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    sorted_flag = false;
                    break;
                }
            }
            if (!sorted_flag) {
                break;
            }
        }

        if (sorted_flag) {
            System.out.println("Sorted");
        } else {
            System.out.println("Not Sorted");
        }
    }

    // Optimal Approach - Just checking the next element until the pattern breaks
    /*
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static void approach2(int[] arr, int n) {
        boolean sorted_flag = true;
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                sorted_flag = false;
                break;
            }
        }
        if (sorted_flag) {
            System.out.println("Sorted");
        } else {
            System.out.println("Not Sorted");
        }
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
