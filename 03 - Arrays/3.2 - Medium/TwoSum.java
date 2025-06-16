/*
 * Leetcode - 1. Two Sum
 * 
 * Given an array of integers arr[] and an integer target. 
 * 
 * 1st variant: Return YES if there exist two numbers such that their sum is equal to the target. 
 * Otherwise, return NO. 
 * 
 * ✅ 2nd variant: Return indices of the two numbers such that their sum is equal to the target. 
 * Otherwise, we will return {-1, -1}. 
 * 
 * Note: You are not allowed to use the same element twice. Example: If the target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {

    // Brute Force Approach -- Checking all possible 2 number combinations
    /*
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public static void approach1(int[] arr, int n, int target) {
        int[] res = { -1, -1 };
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        System.out.println("Result : {" + res[0] + "," + res[1] + "}");
    }

    // Better Approach -- Hashing
    /*
     * Time Complexity - O(n); O(n^2) for worst case of hashmap
     * Space Complexity - O(n)
     */
    public static void approach2(int[] arr, int n, int target) {
        int[] res = { -1, -1 };
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hash.containsKey(target - arr[i])) {
                res[0] = i;
                res[1] = hash.get(target - arr[i]);
                System.out.println("Result : {" + res[0] + "," + res[1] + "}");
                return;
                // so that we don't have to go through again and get the same element.
                // e.g. {2, 4, 11, 3}; target = 6
            }
            hash.put(arr[i], i);
        }
        System.out.println("Result : {" + res[0] + "," + res[1] + "}");
    }

    // Optimal Approach -- Sorting + Two pointer (Not recommended for Variant 2
    // since sorting will change the index)
    /*
     * Time Complexity - O(n) + O(n * log(n)); for loop and sorting resp.
     * Space Complexity - O(1)
     */
    public static void approach3(int[] arr, int n, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (arr[left] + arr[right] < target) {
                left++;
            } else if (arr[left] + arr[right] > target) {
                right--;
            } else {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
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
        System.out.println("Enter the required sum : ");
        int target = sc.nextInt();
        approach3(arr, n, target);
        sc.close();
    }
}
