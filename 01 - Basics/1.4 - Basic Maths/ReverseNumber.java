import java.util.Scanner;

// Optimal Approch
/*
 * Time Complexity - O(log10 N + 1)
 * Space Complexity - O(1)
 */
public class ReverseNumber {
    public static void reverse(int x) {
        int x_copy = Math.abs(x);
        int rev = 0;
        while(x_copy > 0) {
            int digit = x_copy % 10;
            rev = rev*10 + digit;
            x_copy /= 10; 
        }
        if(x<0) rev = -rev;
        System.out.println(rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        reverse(n);
        sc.close();
    }
}
