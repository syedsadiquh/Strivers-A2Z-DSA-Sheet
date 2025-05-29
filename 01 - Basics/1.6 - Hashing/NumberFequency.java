import java.util.HashMap;
import java.util.Scanner;

public class NumberFequency {

    // Using two loops
    public static void approach1(int[] arr, int n) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == true) {
                continue;
            }

            int count = 1;
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " -> " + count);
        }
    }

    // Uisng Map (Hashmap)
    public static void approach2(int[] arr, int n) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int key : arr) {
            if(freqMap.containsKey(key)) {
                freqMap.put(key, freqMap.get(key)+1);
            } else {
                freqMap.put(key, 1);
            }
        }

        freqMap.forEach((Integer k, Integer v) -> {
            System.out.println(k + " -> " + v);
        });
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
        
        approach2(arr, n);
        sc.close();
    }
}
