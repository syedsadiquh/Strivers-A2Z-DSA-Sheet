// Given an array of N integers, left rotate the array by one place.

import java.util.Scanner;

public class LeftRotateByOne {

    // Brute Force Approach
    /*
     * Time Complexity - O(n)
     * Space Complexity - O(n); additional array for result
     */
    public static void approach1(int[] arr, int n) {
        int[] temp = new int[n];
        for (int i = 1; i < n; i++) {
            temp[i-1] = arr[i];
        }
        temp[n-1] = arr[0];

        System.out.println("Rotated Array :");
        for (int i : temp) {
            System.out.print(i+" ");
        }
    }

    // Optimal Approach
    /*
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static void approach2(int[] arr, int n) {
        int first = arr[0];
        for (int i = 0; i <= n-2; i++) {
            arr[i] = arr[i+1];
        }
        arr[n-1] = first;

        System.out.println("Rotated Array :");
        for (int i : arr) {
            System.out.print(i + " ");
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
