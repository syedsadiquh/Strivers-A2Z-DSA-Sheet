import java.util.Scanner;

public class GCD {

    // Brute force approch - working from 1 to min
    /*
     * Time complexity - O(min(n1, n2))
     * Space complexity - O(1)
     */
    public static void approach1(int n1, int n2) {
        int min = Math.min(n1, n2);
        int gcd = 0;
        for(int i = 1; i<=min; i++) {
            if(n1%i==0 && n2%i==0) {
                gcd = i;
            }
        }
        System.out.println(gcd);
    }

    // Better Approch - working from min to 1 
    /*
     * Time complexity - O(min(n1, n2)) -- same but works faster; same time for number with no common factors.
     * Space complexity - O(1)
     */
    public static void approach2(int n1, int n2) {
        for(int i = Math.min(n1, n2); i>=1; i--) {
            if(n1%i==0 && n2%i==0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(1);
        return;
    }

    // Optimal Approach -- uses Euclidean algorithm
    // GCD of two numbers remains the same even if the smaller number is subtracted from the larger number.
    /*
    Eg, n1 = 20, n2 = 15:
    gcd(20, 15) = gcd(20-15, 15) = gcd(5, 15)
    gcd(5, 15) = gcd(15-5, 5) = gcd(10, 5)
    gcd(10, 5) = gcd(10-5, 5) = gcd(5, 5)
    gcd(5, 5) = gcd(5-5, 5) = gcd(0, 5)
    Hence, return 5 as the gcd.
     */
    /*
     * Time Complexity - O(min(n1,n2))
     * Space Complexity - O(1)
     */
    public static void approach3(int n1, int n2) {
        int gcd = 1;
        while (n1>0 && n2>0) {
            if(n1>n2)
                n1 = n1%n2;
            else
                n2 = n2%n1;
        }
        gcd = Math.max(n1, n2);
        System.out.println(gcd);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        approach3(n1, n2);
        sc.close();
    }
}
