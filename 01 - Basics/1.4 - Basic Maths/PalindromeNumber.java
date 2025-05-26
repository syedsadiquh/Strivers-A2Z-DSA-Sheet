import java.util.Scanner;

public class PalindromeNumber {

    // Optimal Approch
    /*
    * Time Complexity - O(log10 N + 1)
    * Space Complexity - O(1)
    */
    public static void printPalindrome(int x) {
        int x_copy = Math.abs(x);
        int rev = 0;
        while(x_copy > 0) {
            rev = rev*10 + (x_copy % 10);
            x_copy /= 10;
        }
        if(x<0) rev = -rev;

        if(Math.abs(x) == rev)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        printPalindrome(n);
        sc.close();
    }
}
