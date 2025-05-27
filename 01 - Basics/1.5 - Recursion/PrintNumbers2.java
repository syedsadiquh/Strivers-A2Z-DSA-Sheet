import java.util.Scanner;

public class PrintNumbers2 {

    public static void printNum(int i, int n) {     // 'i' keep the count of number printed
        System.out.println(i);
        if(i==n) return;
        printNum(i+1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        printNum(1, n);
        sc.close();
    }
}
