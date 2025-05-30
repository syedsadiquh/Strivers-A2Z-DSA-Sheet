import java.util.Scanner;

public class QuickSort {

    // Quick Sort Algorithm
    /*
     * 1. Selects a pivot.
     * 2. puts all smaller element on left and bigger elements on right.
     * 3. recursively does it for both sides.
     * 
     * 
     * Time Complexity - O(NlogN)   -> N for partition and logN for dividing.
     * 
     * Space Complexity - O(1) + some auxiliary stack space (usuaally ignored).
     */
    public static void sort(int[] arr) {
        qs(arr, 0, arr.length-1);
    }

    public static void qs(int[] arr, int low, int high) {
        if (low>high) {     // only one element present i.e. Already sorted
            return;
        }
        int partitionIndex = partition(arr, low, high);
        qs(arr, low, partitionIndex-1);
        qs(arr, partitionIndex+1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;    // Left pointer
        int j = high;   // Right pointer

        while(i<j) {        // Left pointer does not overtake the right pointer
            // finding the index of next element bigger than pivot on right from low side.
            while (arr[i]<=pivot && i<=high-1) {
                i++;
            }
            // finding the index of next elemnet smaller than pivot on left from high side.
            while (arr[j]>pivot && j>=low+1) {
                j--;
            }
            if (i<j) {  // if they haven't crossed each other... swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // when the pointers have crossed => left side of j now have smaller elements and right of j have larger element than pivot
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;   // This is where the partition boundry lies for two unsorted arrays.
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

        sort(arr);

        System.out.println("Sorted Array :");
        for (int i : arr) {
            System.out.print(i+" ");
        }

        sc.close();
    }
}
