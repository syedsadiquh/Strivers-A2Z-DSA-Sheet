// Given an array and a sum k, we need to print the length of the longest subarray that sums to k. 
// Array can only contain positve numbers.

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarraySumPositive {

    public static void approach1(int[] arr, int n, int k) {
        int sum = 0, len = 0;

        // Approach - 1 (Brute Force Approach)
        /*
         * This finds out the sum of all the possible subarrays using two loops and get
         * the sum of that subarray using another loop.
         * 
         * Time compelxity - O(n^3)
         * Space complexity - O(1)
         */
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int j2 = i; j2 <= j; j2++) {
                    sum += arr[j2];
                }
                if (sum == k) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }

        System.out.println("Longest subarray : " + len);

    }

    // Approach - 2 (Optimized Naive Approach)
    /*
     * This method just uses two loops. one signifies the staring index of subarray
     * and another the ending index of the subarray.
     * Each new subarray has one element in the end so, the new sum will just add
     * the new element. Thus, avoiding the thrid loop.
     * 
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public static void approach2(int[] arr, int n, int k) {
        int sum = 0, len = 0;

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == k) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        System.out.println("Longest subarray : " + len);
    }

    // Approach - 3 (Hashing - Prefix Sum)
    /*
     * This approach uses a hashmap to store the prefix sum and uses it to look
     * behind, if there is any index that has the remaining sum. so that we can get
     * the lenght of the subarray.
     * 
     * Time complexity - O(n*log(n)) -- if used ordered map; O(n^2) -- if unordered
     * as the worst case of unordered is O(n)
     * 
     * Space complexity - O(n) -- since in the worst case; all element will have
     * their prefix sum.
     */
    public static void approach3(int[] arr, int n, int k) {
        int sum = 0, len = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == k) {
                len = Math.max(len, i + 1);
            }

            if (prefixSum.containsKey(sum - k)) { // sum - k = remaining sum required
                len = Math.max(len, i - prefixSum.get(sum - k));
            }

            prefixSum.put(sum, i);

            /*
             * Edge case -- if the array has negative or zeros. the prefix sum adds till the
             * rightmost so we need to get the leftmost element that has same prefix sum.
             * We just add a check and add the sum to hash only if its not present, rather
             * than updating it in every iteration.
             * 
             * This will be the most OPTIMAL solution. we can't optimize it further for
             * array having zeros and negatives.
             * 
             * if (!prefixSum.containsKey(sum)) {
             * prefixSum.put(sum, i);
             * }
             * 
             */
        }

        System.out.println("Longest subarray : " + len);
    }

    // Optimal approach (Two Pointer Approach)
    /*
     * Keep on adding the 2st pointer(right) and when if the sum > K then, move 1nd pointer(left) ahead, thus reducing the sum.
     * 
     * Time complexity - O(2n)
     * Space complexity - O(1)
     */
    public static void approach4(int[] arr, int n, int k) {
        int left = 0, right = 0, sum = arr[0], len = 0;
        while (right<n) {
            while (sum > k && left<=right) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                len = Math.max(len, right-left+1);
            }

            right++;
            if (right<n) {
                sum += arr[right];
            }
            
        }

        System.out.println("Longest subarray : " + len);
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
        int k = sc.nextInt();
        approach3(arr, n, k);
        sc.close();
    }
}
