import java.util.Scanner;

public class RecursiveSelectionSort {
    /*
     * Recursive Selection Sort --
     *      Everything same as selection sort but just utilizing recursion for outer loop.
     * 
     * Time complexity - O(n^2)  {best, worst and average}
     * 
     * Space complexity - O(N) auxiliary stack space
     */

    public static void sort(int[] arr, int n) {
        if (n==0) return;

        int max = 0;        // Index of the maximum value
        for(int j = 0; j<=n; j++) {
            if (arr[j] > arr[max]) {
                max = j;
            }
        }

        int temp = arr[max];
        arr[max] = arr[n];
        arr[n] = temp;

        sort(arr, n-1);
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

        sort(arr, n-1);

        System.out.println("Sorted Array :");
        for (int i : arr) {
            System.out.print(i+" ");
        }

        sc.close();
    }
}
