//  Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays. 
// The union of two arrays can be defined as the common and distinct elements in the two arrays.
// NOTE: Elements in the union should be in ascending order.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class UnionSortedArray {

    // Using Map i.e. Hashmap
    /*
     * Time Complexity - O((m+n) log(m+n))
     * Space Complexity - O(m+n); for the ArrayList it can have max of m+n elements
     */
    public static void approach1(int[] arr1, int[] arr2, int m, int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> union = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            hashMap.put(arr1[i], hashMap.getOrDefault(arr1[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            hashMap.put(arr2[i], hashMap.getOrDefault(arr2[i], 0) + 1);
        }
        for (Integer key : hashMap.keySet()) {
            union.add(key);
        }
        for (Integer integer : union) {
            System.out.print(integer + " ");
        }
    }

    // Using Sorted Set i.e. TreeSet
    /*
     * Time Complexity - O((m+n) log(m+n))
     * Space Complexity - O(1);  if ArrayList is used for returning result, then O(m+n)
     */
    public static void approach2(int[] arr1, int[] arr2, int m, int n) {
        TreeSet<Integer> ele = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            ele.add(arr1[i]);
        }
        for (int i = 0; i < n; i++) {
            ele.add(arr2[i]);
        }
        for (Integer integer : ele) {
            System.out.print(integer + " ");
        }
    }

    // Using two pointers -- Only Sorted arrays
    /*
     * Time Complexity - O(m+n); since already sorted we need to just traverse in a smart way.
     * Space Complexity - O(m+n); union ArrayList take max of m+n element
     */
    public static void approach3(int[] arr1, int[] arr2, int m, int n) {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        while (i<m && j<n) {
            if (arr1[i] <= arr2[j]) {       // when equal(case 1) and less than(case 2), checking the last element to avoid duplicates
                if (union.size() == 0 || union.get(union.size()-1) != arr1[i])
                    union.add(arr1[i]);
                i++;
            }
            else {        // when greater than(case 3), adding after checking as above.
                if (union.size() == 0 || union.get(union.size()-1) != arr2[j]) 
                    union.add(arr2[j]);
                j++;
            }
        }
        while (i<m) {      // left over elements from arr1
            if (union.get(union.size()-1) != arr1[i]) 
                union.add(arr1[i]);
            i++;
        }
        while (j<n) {      // left over elements from arr2
            if (union.get(union.size()-1) != arr2[j]) 
                union.add(arr2[j]);
            j++;
        }

        for (Integer integer : union) {
            System.out.print(integer+" ");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the number of elements : ");
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // System.out.println("Enter the Elements in array : ");
        // for (int i = 0; i < n; i++) {
        // arr[i] = sc.nextInt();
        // }

        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] arr2 = { 2, 3, 4, 4, 5, 11, 12 };
        int m = 10;
        int n = 7;
        approach3(arr1, arr2, m, n);
        sc.close();
    }
}
