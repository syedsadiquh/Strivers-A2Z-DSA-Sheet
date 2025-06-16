
/*
 * Leetcode - 53. Maximum Subarray
 * Given an integer array arr, find the contiguous subarray (containing at least one number) which 
 * has the largest sum and returns its sum and prints the subarray.
 */
import java.util.Scanner;

public class MaximumSubarraySum {

    // Brute Force Approach
    /*
     * Time Complexity - O(n^3)
     * Space Complexity - O(1)
     */
    public static void approach1(int[] arr, int n) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println("Maxiumum Sum : " + maxSum);
    }

    // Better Approach
    /*
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public static void approach2(int[] arr, int n) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println("Maximum Sum : " + maxSum);
    }

    // Optimal Approach - Kadane's Algorithm
    /*
     * This algorithm replaces any negative in sum with zero as carrying on the
     * negative sum will only hamper the total sum in future.
     * 
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static void approach3(int[] arr, int n) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        int start = 0, ansS = 0, ansE = 0;
        for (int i = 0; i < n; i++) {
            if (sum == 0)
                start = i;
            sum += arr[i];
            // maxSum = Integer.max(maxSum, sum);
            if (sum > maxSum) {
                maxSum = sum;
                ansS = start;
                ansE = i;
            }
            if (sum < 0)
                sum = 0;
        }
        System.out.println("Maximum Sum : " + maxSum);
        for (int i = ansS; i <= ansE; i++) {
            System.out.print(arr[i] + " ");
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
