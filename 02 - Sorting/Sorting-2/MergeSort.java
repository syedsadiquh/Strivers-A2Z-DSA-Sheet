import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {

    // Merge Sort - Uses Divide and Merge system
    /*
     * Time complexity - O(n * log2 n)  {best, worst and average}
     * 
     * Space complexity - O(n)  i.e. used by the merge method in worst case.
     */
    public static void sort(int[] arr, int low, int high) {
        // Base case for stopping when there's only one element in the sub-array
        if(low>=high) return;

        int mid = (low+high) / 2;
        sort(arr, low, mid);
        sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while (left<=mid && right<=high) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // all elements left on left
        while(left<=mid) {
            temp.add(arr[left]);
            left++;
        }
        // all elements left on right
        while (right<=high) {
            temp.add(arr[right]);
            right++;
        }

        // copy to original array
        for(int i = low; i<=high; i++) {
            arr[i] = temp.get(i-low);
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

        sort(arr, 0, n-1);

        System.out.println("Sorted Array :");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        sc.close();
    }
}
