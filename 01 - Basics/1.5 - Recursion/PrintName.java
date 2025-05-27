import java.util.Scanner;

public class PrintName {

    public static void printName(int n) {
        System.out.println("Syed Sadiqu Hussain");
        if(n==1) return;
        printName(n-1);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        printName(n);
        sc.close();
    }
}
