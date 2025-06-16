/*
 * Leetcode - 75. Sort Colors
 * Given an array consisting of only 0s, 1s, and 2s. 
 * Write a program to in-place sort the array without using inbuilt sort functions. 
 * (Expected: Single pass-O(N) and constant space)
 */

import java.util.Arrays;
import java.util.Scanner;

public class Sort0s1s2s {

    // Brute Force Approach -- Just sort even though its not expected but it is also
    // an answer.
    /*
     * Time Complexity - O(n * log(n))
     * Space Complexity - O(1)
     */
    public static void approach1(int[] arr, int n) {
        Arrays.sort(arr);
        System.out.println("Sorted array : ");
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }

    // Better Approach -- counting of 0s, 1s and 2s
    /*
     * Time Complexity - O(2n)
     * Space Complexity - O(1)
     */
    public static void approach2(int[] arr, int n) {
        int count_0 = 0, count_1 = 0;
        // int count_2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count_0++;
            } else if (arr[i] == 1) {
                count_1++;
            } else {
                // count_2++;
            }
        }
        for (int i = 0; i < count_0; i++) {
            arr[i] = 0;
        }
        for (int i = count_0; i < count_0 + count_1; i++) {
            arr[i] = 1;
        }
        for (int i = count_0 + count_1; i < n; i++) {
            arr[i] = 2;
        }

        System.out.println("Sorted array : ");
        for (Integer x : arr) {
            System.out.print(x + " ");
        }
    }

    // Optimal Approach - variation of Dutch National Flag Algorithm (uses three
    // pointers - low, mid and high)
    /*
     * This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.
     * The rules are the following:
     *      arr[0….low-1] contains 0. [Extreme left part]
     *      arr[low….mid-1] contains 1.
     *      arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
     * The middle part i.e. arr[mid...high] is the unsorted segment. So,
     * hypothetically the array with different markers will look like the following:
     * 
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static void approach3(int[] arr, int n) {
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) { // this overlap means the unsorted part is over
            if (arr[mid] == 0) {
                // swap with low
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                // Adjust pointers as per new sorted and unsorted part
                low++;
                mid++;
            } else if (arr[mid] == 1) { // if it's one than it's already in acc. to the rules and is sorted.
                mid++;
            } else { // since, it's 2. It goes to high place to have [high+1 ... n-1] are all 2.
                // swap with high
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                // adjust pointers.
                high--;
                // mid doesn't move as the swap element might not be in order so it needs to be
                // checked.
            }
        }
        System.out.println("Sorted array : ");
        for (Integer integer : arr) {
            System.out.print(integer + " ");
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
        approach3(arr, n);
        sc.close();
    }
}
