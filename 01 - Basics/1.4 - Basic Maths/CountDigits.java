// Program to count the number of digits
import java.util.Scanner;

public class CountDigits {

    // Brute-Force - Uses loop for each digit

    /*  Time Complexity - O(log10 N + 1)
    * -> we loop by divide N by 10 which takes (log10 N) iterations
    * -> we perform addtion & division so constant time i.e. O(1)
    
        Constant Space compelxity - O(1)
     */
    public static void approch1(int n) {
        int counter = 0;

        while(n>0) {
            counter++;
            n/=10;
        }

        System.out.println(counter);
    }

    // Optimal Approch - Uses Logarithm
    /*
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     */
    public static void approch2(int n) {
        // log10 returns the power to which 10 must be raised to, to be equal to N
        // Adding 1 to ensures for the possibility that N itself is a power of 10
        int count = (int) Math.log10(n) + 1;   
        System.out.println(count);
    }

    // Optimal Approch
    public static void approch3(int n) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        approch2(n);

        sc.close();
    }
}
