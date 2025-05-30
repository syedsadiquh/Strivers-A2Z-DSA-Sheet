import java.util.Scanner;

public class RecursiveBubbleSort {
    /* 
     * Recursive Bubble sort -- 
     *   everything same just that the outer loop is removed and instead of that recursion is used. 
     *  Time complexity - 
     *      for unoptimized - O(N^2)  {best, worst and average case}
     *      for optimized (using didSwap flag) - O(N^2) {worst and average case}  && O(N) {best case}
     * 
     * Space complexity - O(N) auxiliary stack space
    */

    public static void sort(int[] arr, int n) {
        if (n==1) return;

        for (int j = 0; j <= n-2; j++) {
            if (arr[j]>arr[j+1]) {
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }

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

        sort(arr, n);

        System.out.println("Sorted Array :");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        sc.close();
    }
}
