import java.util.Scanner;

public class PrintNumbers {

    // Prints at decending order
    public static void printNum(int n) {
        System.out.println(n);
        if(n==1) return;
        printNum(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        printNum(n);
        sc.close();
    }
}
