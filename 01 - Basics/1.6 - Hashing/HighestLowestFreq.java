import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Scanner;

public class HighestLowestFreq {

    public static void minMaxFreq(int[] arr, int n) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int x : arr) {
            if(freqMap.containsKey(x)) 
                freqMap.put(x, freqMap.get(x)+1);
            else
                freqMap.put(x, 1);
        }

        int maxE = 0, minE = 0;
        int maxF = 0, minF = n;
        for (Entry<Integer, Integer> i : freqMap.entrySet()) {
            if(i.getValue()>maxF) {
                maxE = i.getKey();
                maxF = i.getValue();
            }
            if(i.getValue()<minF) {
                minE = i.getKey();
                minF = i.getValue();
            }
        }
        

        System.out.println("Maximum Freq Element: "+maxE);
        System.out.println("Minimum Freq Element: "+minE);
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

        minMaxFreq(arr, n);
        sc.close();
    }
}
