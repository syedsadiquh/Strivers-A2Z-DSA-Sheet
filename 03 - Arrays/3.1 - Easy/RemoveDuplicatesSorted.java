// Program to remove the duplicates from a sorted array.

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class RemoveDuplicatesSorted {

    // Just generic approach -- too bad
    /*
     * Time complexity - O(n^2)
     * Space complexity - O(n)
     */
    public static void approach1(int[] arr, int n) {
        int[] unique = new int[n];
        int uindex = 0;
        for (int i = 0; i < n; i++) {
            boolean u = true; // Considering that the element is unique.. i.e no present in unique array
            for (int j = 0; j < n; j++) {
                if (arr[i] == unique[j]) { // if the element in arr[i] already present in unique; break;
                    u = false;
                    break;
                }
            }
            if (u) {
                unique[uindex] = arr[i];
                uindex++;
            }
        }

        arr = unique.clone();
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // Brute Force approach -- using hashset
    /*
     * Time Complexity - O(n*log(n))+O(n)
     * Space Complexity - O(n)
     */
    public static void approach2(int[] arr, int n) {
        HashSet<Integer> uniqueSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueSet.add(arr[i]);
        }
        Iterator<Integer> iter = uniqueSet.iterator();
        for (int i = 0; i < n; i++) {
            if (iter.hasNext()) {
                arr[i] = iter.next();
            } else {
                arr[i] = 0;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // Optimal Approach - Two pointers; i for element and j moves ahead until j-th
    // element is diff from i-th element.
    /*
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static void approach3(int[] arr, int n) {
        int i = 0, j = 1;
        for (; j < n; j++) {
            if (arr[i] != arr[j]) { // new element found
                i++;
                arr[i] = arr[j];
            }
        }

        for (int j2 = 0; j2 < i + 1; j2++) {
            System.out.print(arr[j2] + " ");
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
