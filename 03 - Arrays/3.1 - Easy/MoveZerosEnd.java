// Program to move all the zeros to the end of the array while maintaing the order of all non-negative integers.

import java.util.Scanner;

public class MoveZerosEnd {

    // Brute Force Approach - using extra array
    /*
     * Time complextiy - O(2n)
     * Space complexity - O(n)
     */
    public static void approach1(int[] arr, int n) {
        int[] temp = new int[n];
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[x] = arr[i];
                x++;
            }
        }
        for (int i = 0; i < x; i++) {
            arr[i] = temp[i];
        }
        for (int i = x; i < n; i++) {
            arr[i] = 0;
        }

        System.out.println("Modified Array :");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // Optimal Approach - Two pointer approach
    /*
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public static void approach2(int arr[], int n) {
        int i = 0, j = 1;
        for (; j < n; j++) {
            if (arr[j] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        System.out.println("Modified Array :");
        for (int x : arr) {
            System.out.print(x + " ");
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
