// Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.

import java.util.Scanner;

public class MaxConsecutiveOnes {

    // Counting Approach
    /*
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static void approach1(int[] arr, int n) {
        int max1s = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1)
                count++;
            else
                count = 0;

            if (count > max1s)
                max1s = count;
        }

        System.out.println("Max consecutive 1s is " + max1s);
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
        approach1(arr, n);
        sc.close();
    }
}
