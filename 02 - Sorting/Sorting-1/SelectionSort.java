import java.util.Scanner;

public class SelectionSort {

    // Selection Sort
    /*
     * Time complexity - O(n^2)  {best, worst and average}
     * 
     * Space complexity - O(1)
     */
    public static void sort(int[] arr, int n) {
        int minI;
        for(int i = 0; i<n-1; i++) {
            minI = i;
            // Selecting the index of minimum element.
            for(int j = i+1; j<n; j++) {
                if (arr[j] < arr[minI]) {
                    minI = j;
                }
            }
            // Swapping the i-th to the min of the left over array.
            int temp = arr[i];
            arr[i] = arr[minI];
            arr[minI] = temp;
        }

        System.out.println("Sorted Array : ");
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
