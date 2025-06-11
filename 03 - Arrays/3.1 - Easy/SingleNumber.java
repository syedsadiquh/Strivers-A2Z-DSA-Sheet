// Leetcode 136. Single Number -- find the single number in array where every element is twice

import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Scanner;

public class SingleNumber {

    // Brute Force Approach
    /*
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public static void approach1(int[] arr, int n) {
        int missing = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count != 2) {
                missing = arr[i];
                break;
            }
        }
        System.out.println("Single Number : "+ missing);
    }

    // Better Approach - 1 (Array Hashing)
    /*
     * Time Complexity - O(3n)
     * Space Complexity - O(m); m = maxElement + 1
     */
    public static void approach2(int[] arr, int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] hash = new int[max+1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1) {
                System.out.println("Single Number : "+arr[i]);
                break;
            }
        }
    }

    // Better Approach - 2 (Map Hashing)
    /*
     * Time Complexity - O(2n)
     * Space Complexity - O(m); m = (n/2)+1
     */
    public static void approach3(int[] arr, int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0)+1);
        }
        for (Entry<Integer, Integer> i : hashMap.entrySet()) {
            if (i.getValue() == 1) {
                System.out.println("Single Number : " + i.getKey());
                break;
            }
        }
    }

    // Optimal Approach -- XOR Approach (XOR of all elements in array will lead to one number without pair thus our result)
    /*
     * Time complexity - O(n)
     * Space Complexity - O(1)
     */
    public static void approach4(int[] arr, int n) {
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        System.out.println("Single Number : " + xor);
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
        approach4(arr, n);
        sc.close(); 
    }
}
