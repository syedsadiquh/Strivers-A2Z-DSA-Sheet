import java.util.ArrayList;
import java.util.Scanner;

public class PrintDivisors {

    // Brute Force Approach
    /*
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public static void approach1(int n) {
        ArrayList<Integer> div = new ArrayList<>();
        for(int i = 1; i<=n; i++) {
            if(n%i == 0) div.add(i);
        }
        
        for (Integer x : div) {
            System.out.print(x+ " ");
        }
    }

    // Optimal Approach -- going till the square root; uses the symmetric property of factors and multiplicaiton
    /*
     * Time Complexity - O(sqrt(N))  -- The algorithm iterates through each number from 1 to the square root of N
     * Space Complexity - O(2*sqrt(N))  -- This approach allocates memory for an array to hold all the divisors. The size of this array could go to be 2*(sqrt(N)).
     */
    public static void approach2(int n) {
        ArrayList<Integer> div = new ArrayList<>();
        for(int i = 1; i<Math.sqrt(n); i++) {
            if(n%i == 0) {
                div.add(i);    // If i is a divisor, add it to the arraylist

                if(i != n/i) div.add(n/i);  // If i is different from n/i add the counterpart divisor n/i to the arraylist
            } 
        }

        for (Integer x : div) {
            System.out.print(x+ " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        approach2(n);
        sc.close();
    }
}
