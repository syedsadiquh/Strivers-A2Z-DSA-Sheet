/* 
Given an array, find the second smallest and second largest element in the array. 
Print ‘-1’ in the event that either of them doesn’t exist.
*/

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestSmallest {
    // Brute Force Approach -- Sorting and setting the index 1 and n-1.
    /*
     * Time Complexity - O(n log(n))
     * Space Complextity - O(1)
     */
    public static void approach1(int[] arr, int n) {
        if (n < 2) {
            System.out.println("Second Largest : -1");
            System.out.println("Second Smallest : -1");
            return;
        }
        Arrays.sort(arr); // double-pivot quick sort -- O(n log(n))
        System.out.println("Second Largest : " + arr[n - 2]);
        System.out.println("Second Smallest : " + arr[1]);
    }

    // Better Approach -- Traversing once to get the smallest and largest element and then, the 2nd smallest and 2nd largest.
    /*
     * Time Complexity - O(n); traversitng 2 times i.e O(2n) to be precise
     * Space Complexity - O(1)
     */
    public static void approach2(int[] arr, int n) {
        if (n < 2) {
            System.out.println("Second Largest : -1");
            System.out.println("Second Smallest : -1");
            return;
        }
        int max = arr[0], min = arr[0], max2 = arr[0], min2 = arr[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] < min2 && arr[i] != min) {
                min2 = arr[i];
            }
            if (arr[i] > max2 && arr[i] != max) {
                max2 = arr[i];
            }
        }
        System.out.println("Second Largest : " + max2);
        System.out.println("Second Smallest : " + min2);
    }

    // Optimal Approach -- Storing max, 2nd max, min and 2nd min in a single iteration
    /*
     * Time Complexity - O(n); traversing only once
     * Space Complexity - O(1)
     */
    public static void approach3(int[] arr, int n) {
        if (n < 2) {
            System.out.println("Second Largest : -1");
            System.out.println("Second Smallest : -1");
            return;
        }
        int max = arr[0], min = arr[0], max2 = arr[0], min2 = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max2 = max;
                max = arr[i];
            } else if (arr[i] > max2 && arr[i] != max) {
                max2 = arr[i];
            }

            if (arr[i] < min) {
                min2 = min;
                min = arr[i];
            } else if (arr[i] < min2 && arr[i] != min) {
                min2 = arr[i];
            }
        }
        System.out.println("Second Largest : " + max2);
        System.out.println("Second Smallest : " + min2);
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

        approach2(arr, n);

        sc.close();
    }
}
