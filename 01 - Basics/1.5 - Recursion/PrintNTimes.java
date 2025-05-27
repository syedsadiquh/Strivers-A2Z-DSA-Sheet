import java.util.Scanner;

public class PrintNTimes {

    public static void print(int n) {
        System.out.println("Hello from Iteration "+n);
        if(n==1) return;
        print(--n);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        print(n);
        sc.close();
    }
}
