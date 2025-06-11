// Given an array and a sum k, we need to print the length of the longest subarray that sums to k. 
// Array can contain positves, negatives and zeros.

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarraySumNegativeZero {

    // Brute Force Approach -- exploring every possible subset of array
    /*
     * Time Complexity - O(n^3)
     * Space Complexity - O(1)
     */
    public static void approach1(int[] arr, int n, int k) {
        int sum = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int j2 = i; j2 <= j; j2++) {
                    sum += arr[j2];
                }
                int len = j - i + 1;
                if (sum == k) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        System.out.println("Longest Subarray Length : " + maxLen);
    }

    // Better Approach -- remove the need of loop for summation
    /*
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public static void approach2(int[] arr, int n, int k) {
        int sum = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == k) {
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        System.out.println("Longest Subarray Length : " + maxLen);
    }

    // Optimal Approach -- Using Hashmap i.e. Prefix Sum Approach
    /*
     * Time Complexity - O(n * log(n))
     * Space Complexity - O(n)
     */
    public static void approach3(int[] arr, int n, int k) {
        int sum = 0, maxLen = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = Math.max(maxLen, i+1);
            }

            if (prefixSum.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixSum.get(sum - k));
            }

            if (!prefixSum.containsKey(sum)) {      // This help avoiding the overwriting of value for zeros.
                prefixSum.put(sum, i);
            }
        }
        System.out.println("Longest Subarray Length : " + maxLen);
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
        System.out.println("Enter the Required Sum : ");
        int k = sc.nextInt();
        approach3(arr, n, k);
        sc.close();
    }
}
