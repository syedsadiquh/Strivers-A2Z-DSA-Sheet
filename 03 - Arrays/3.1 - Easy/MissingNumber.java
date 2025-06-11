// Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. 
// Find the number(between 1 to N), that is not present in the given array.

import java.util.HashMap;
import java.util.Scanner;

public class MissingNumber {

    // Brute Force Approach -- performing linear search for all nums between 1 to n
    /*
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public static void approach1(int[] arr, int n) {
        boolean found;
        for (int i = 1; i <= n; i++) {
            found = false;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(i + " is Missing.");
            }
        }
    }

    // Better Approach -- Using Hashmap
    /*
     * Time Complexity - O(2n) => O(n)
     * Space Complexity - O(n)
     * 
     */
    public static void approach2(int[] arr, int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            if (!hashMap.containsKey(i)) {
                System.out.println(i + " is Missing.");
            }
        }
    }

    // Optimal Approach -- Summation approach; use (n*(n+1))/2
    /*
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public static void approach3(int[] arr, int n) {
        int expSum = (n * (n + 1)) / 2;
        int realSum = 0;
        for (int i : arr) {
            realSum += i;
        }
        if (realSum == expSum) {
            System.out.println("No element missing");
        } else {
            System.out.println("Missing element : " + (expSum - realSum));
        }
    }

    // Optimal Approach -- XOR approach
    /*
     * Two important properties of XOR are the following:
     * 
     * XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
     * XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.
     * ←Property 2
     * 
     * Now, let’s XOR all the numbers between 1 to N.
     * xor1 = 1^2^.......^N
     * 
     * Let’s XOR all the numbers in the given array.
     * xor2 = 1^2^......^N (contains all the numbers except the missing one).
     * 
     * Now, if we again perform XOR between xor1 and xor2, we will get:
     * xor1 ^ xor2 = (1^1)^(2^2)^........^(missing Number)^.....^(N^N)
     * 
     * Here all the numbers except the missing number will form a pair and each pair
     * will result in 0 according to the XOR property. The result will be = 0 ^
     * (missing number) = missing number (according to property 2).
     * 
     * 
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static void approach4(int[] arr, int n) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < n; i++) {
            xor1 ^= arr[i];
            xor2 ^= i + 1;
        }
        xor1 = xor1 ^ xor2;
        System.out.println("Missing element : " + xor1);
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
