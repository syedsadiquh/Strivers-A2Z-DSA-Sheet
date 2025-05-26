import java.util.Scanner;

public class Armstrong {

    // Optimal Approach
    /*
     * Time complexity - O(log10(N) + 1)
     * Space complexity - O(1)
     */
    public static void printArmstrong(int n) {
        int digits =(int) Math.log10(n) + 1;    // OR   int k = String.valueOf(num).length();
        int newNumber = 0, n_copy = n;
        while(n_copy>0) {
            newNumber += Math.pow(n_copy%10, digits);
            n_copy/=10;
        }
        if(n == newNumber)
            System.out.println("Armstrong Number");
        else
            System.out.println("Not Armstrong Number");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        printArmstrong(n);
        sc.close();
    }
}
