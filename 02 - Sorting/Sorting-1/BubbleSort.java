import java.util.Scanner;

public class BubbleSort {

    // Bubble Sort
    /*
     * Time complexity - 
     *      for unoptimized - O(N^2)  {best, worst and average case}
     *      for optimized - O(N^2) {worst and average case}  && O(N) {best case}
     * 
     * Space complexity - O(1)
     */
    public static void sort(int[] arr, int n) {
        for (int i = n-1; i >= 0; i--) {
            // Optimization using a simple swap flag.
            boolean didSwap = false;

            for (int j = 0; j <= i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = true;
                }
            }

            // This will break the loop if the prev. iteration has no swaps i.e. the array is already sorted.
            if(!didSwap)
                break;
        }

        System.out.println("Sorted Array :");
        for (int i : arr) {
            System.out.print(i+" ");
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

        sort(arr, n);
        sc.close();
    }
}
