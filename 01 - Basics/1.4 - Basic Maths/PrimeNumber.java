import java.util.Scanner;

public class PrimeNumber {
    
    // Brute Force Approach
    /*
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public static void approach1(int n) {
        int counter = 0;
        for(int i = 1; i<=n; i++) {
            if(n%i == 0) {
                counter++;
            }
        }
        if(counter == 2) System.out.println("prime");
        else System.out.println("not prime");
    }

    // Optimal Approach - uses the symmetric property of factors and multiplicaiton
    /*
     * Time Complexity - O(sqrt(n))
     * Space Complexity - O(1)
     */
    public static void approach2(int n) {
        int counter = 0;
        for(int i = 1; i<Math.sqrt(n); i++) {
            if(n%i == 0) {
                counter++;
                if(i != n%i) {
                    counter++;
                }
            }
        }
        if(counter == 2) System.out.println("Prime");
        else System.out.println("Not Prime");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        approach1(n);
        sc.close();
    }
}
