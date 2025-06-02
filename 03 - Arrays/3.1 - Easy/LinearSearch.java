import java.util.Scanner;

public class LinearSearch {

    // Linear Search Algorithm
    /*
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public static void search(int[] arr, int n, int num) {
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                res = i;
                break;
            }
        }

        if (res != -1) {
            System.out.println("Item found at index : "+res);
        } else {
            System.out.println("Item not found...");
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
        System.out.println("Enter the number to find : ");
        int num = sc.nextInt();
        search(arr, n, num);
        sc.close();
    }
}
