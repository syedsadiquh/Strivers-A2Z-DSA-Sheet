import java.util.Scanner;

public class InsertionSort {

    // Insertion Sort
    /*
     * Time complexity - O(N^2) {worst and average} && O(N) {best = already sorted; inner loops run 0 times}
     * 
     * Space complexity - O(1)
     */
    public static void sort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j-1] > arr[j]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else {
                    // No swapping mean its in correct position
                    break;
                }
            }
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
