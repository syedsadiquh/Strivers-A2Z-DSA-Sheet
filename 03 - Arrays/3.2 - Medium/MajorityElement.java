/*
 * 169. Majority Element
 * Given an array of N integers, write a program to return an element that occurs 
 * more than N/2 times in the given array. 
 * You may consider that such an element always exists in the array.
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class MajorityElement {

    // Brute Force Approach
    /*
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public static void approach1(int[] arr, int n) {
        int element = 0, count = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > n / 2) {
                element = arr[i];
                break;
            }
        }
        System.out.println("Majority Element : " + element);
    }

    // Better Approach
    /*
     * Time Complexity - O(n * log(n)) + O(n)   {insersion + checking}; 
     *      for worst case : O(n^2) + O(n) 
     * 
     * Space Complexity - O(n)
     */
    public static void approach2(int[] arr, int n) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }
        for (Entry<Integer, Integer> x : hash.entrySet()) {
            if (x.getValue() > n / 2) {
                System.out.println("Majority Element : " + x.getKey());
                break;
            }
        }
    }

    // Optimal Approach - Moore’s Voting Algorithm
    /*
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static void approach3(int[] arr, int n) {
        int count = 0, element = arr[0];
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = arr[i];
                count++;
            }
            else if (element == arr[i])
                count++;
            else
                count--;
        }
        System.out.println("Majority Element : " + element);
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
