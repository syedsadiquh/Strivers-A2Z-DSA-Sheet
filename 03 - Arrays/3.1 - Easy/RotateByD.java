// Given an array of integers, rotating array of elements by k elements either left or right.

import java.util.Scanner;

public class RotateByD {

    /*
     * Time complexity - O(n)
     * Space complexity - O(k)
     */
    public static void rotateRight(int[] arr, int n, int k) {
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[n - k + i];
        }
        for (int i = n - 1 - k; i >= 0; i--) {
            arr[i + k] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }

        System.out.println("RIGHT Rotated Array :");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /*
     * Time complexity - O(n)
     * Space complexity - O(k)
     */
    public static void rotateLeft(int[] arr, int n, int k) {
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        for (int i = 0; i < n - k; i++) {
            arr[i] = arr[i + k];
        }
        for (int i = 0; i < k; i++) {
            arr[n - k + i] = temp[i];
        }
        System.out.println("LEFT Rotated Array :");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void Reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to Rotate k elements to right
    /*
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public static void recursiveRotateRight(int[] arr, int n, int k) {
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;

        // Reverse first n-k elements
        Reverse(arr, 0, n - k - 1);
        // Reverse last k elements
        Reverse(arr, n - k, n - 1);
        // Reverse whole array
        Reverse(arr, 0, n - 1);
    }

    // Function to Rotate k elements to left
    /*
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public static void recursiveRotateLeft(int[] arr, int n, int k) {
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;

        // Reverse first k elements
        Reverse(arr, 0, k - 1);
        // Reverse last n-k elements
        Reverse(arr, k, n - 1);
        // Reverse whole array
        Reverse(arr, 0, n - 1);
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
        System.out.println("Enter the places to shift : ");
        int k = sc.nextInt();
        System.out.println("Enter Left(0) or Right(1) : ");
        int choice = sc.nextInt();

        if (choice == 1)
            rotateRight(arr, n, k);
        else
            rotateLeft(arr, n, k);
        sc.close();
    }
}