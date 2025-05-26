/* Pattern Question from Striver a2z sheet - https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/ */

import java.util.Scanner;

public class Patterns {

    public static void pattern1(int n) {
        /*

        *****
        *****
        *****
        *****
        *****

         */

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n) {
        /*
        
        *
        **
        ***
        ****
        *****

         */

        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern3(int n) {
        /*
        1
        12
        123
        1234
        12345
         */
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void pattern4(int n) {
        /*
        1
        22
        333
        4444
        55555
         */
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static void pattern5(int n) {
        /*
        
        *****
        ****
        ***
        **
        *

         */
        for(int i=0; i<n; i++) {
            for(int j=n; j>i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern6(int n) {
        /*
        12345
        1234
        123
        12
        1
         */
        for(int i=n; i>0; i--) {
            for(int j=1; j<=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void pattern7(int n) {
        /*
            *
           ***
          *****
         *******
        *********
         */
        for(int i=1; i<=n; i++) {
            // space
            for(int j=i; j<n; j++) {
                System.out.print(" ");
            }
            // star
            for(int j=1; j<2*i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern8(int n) {
        /*
        *********
         *******
          *****
           ***
            *
         */
        for(int i=n; i>0; i--) {
            // Space
            for(int j=i; j<n; j++) {
                System.out.print(" ");
            }
            // Star
            for(int j=1; j<2*i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern9(int n) {
        /*  THIS IS THE COMBINATION OF PATTERN7 AND PATTERN8.
            *
           ***
          *****
         *******
        *********
        *********
         *******
          *****
           ***
            *
         */
        
        pattern7(n);
        pattern8(n);
    }
    public static void pattern10(int n) {
        /*
        *
        **
        ***
        ****
        *****
        ****
        ***
        **
        *
         */
        for(int i=1; i<2*n; i++) {
            int stars = i;
            if(i>n) stars = 2*n - i;
            for(int j=0; j<stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern11(int n) {
        /*
        1
        0 1
        1 0 1
        0 1 0 1
        1 0 1 0 1
         */
        // Approch-1 (self)(taking loops as 5->45->345->2345->12345 and even/odd of each number)
        for(int i=n; i>0; i--){
            for(int j=i; j<=n; j++) {
                System.out.print(j%2);
            }
            System.out.println();
        }

        // Approch-2 (only seeing the start as even/odd and then flip-flip the value)
        int start = 1;
        for(int i=0; i<n; i++) {
            if(i%2 == 0) start = 1;
            else start = 0;
            for(int j=0; j<=i; j++) {
                System.out.print(start);
                start = 1-start; // Fliping between 0 and 1
            }
            System.out.println();
        }
    }
    public static void pattern12(int n) {
        /*
        1        1
        12      21
        123    321
        1234  4321
        1234554321
         */
        int spaces = 2*(n-1);
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(j);
            }
            for(int j=spaces; j>0; j--) {
                System.out.print(" ");
            }
            for(int j=i; j>0; j--) {
                System.out.print(j);
            }
            spaces -= 2;
            System.out.println();
        }
    }
    public static void pattern13(int n) {
        /*
        1
        2 3
        4 5 6 
        7 8 9 10
        11 12 13 14 15
         */
        int counter = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }
    public static void pattern14(int n) {
        /*
        A
        AB
        ABC
        ABCD
        ABCDE
         */
        for(int i=0; i<n; i++) {
            for(char j='A'; j<='A'+i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void pattern15(int n) {
        /*
        ABCDE
        ABCD
        ABC
        AB
        A
         */
        for(int i=n-1; i>=0; i--) {
            for(char j='A'; j<='A'+i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void pattern16(int n) {
        /*
        A
        BB
        CCC
        DDDD
        EEEEE
         */
        for(char i='A'; i<'A'+n; i++) {
            for(char j='A'; j<=i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static void pattern17(int n) {
        /*
            A
           ABA
          ABCBA
         ABCDCBA
        ABCDEDCBA
         */
        char ch;

        // Approch - 1 (self)
        for(int i=0; i<n; i++) {
            // spaces
            for(int j=n-1; j>i; j--) {
                System.out.print(" ");
            }
            // Characters
            for(int j=0; j<=(2*i); j++) {
                if (j<=i) ch = (char) ('A'+j);
                else ch = (char) ('A'+(2*i-j));
                System.out.print(ch);
            }
            System.out.println();
        }

        // Approch - 2
        for(int i = 0; i<n; i++) {
            // Spaces
            for(int j = n-1; j>i; j--) {
                System.out.print(" ");
            }

            // Characters
            ch = 'A';
            int breakpoint = (2*i+1) / 2;       // Define a breakpoint after which the increment changes to decrement.
            for(int j = 1; j<=2*i+1; j++) {
                System.out.print(ch);
                if(j<=breakpoint) ch++;
                else ch--;
            }
            System.out.println();
        }
    }
    public static void pattern18(int n) {
        /*
        E
        D E
        C D E
        B C D E
        A B C D E
         */
        for(int i = n-1; i>=0; i--) {
            for(int j = i; j<n; j++) {
                System.out.print((char)('A'+j) + " ");
            }
            System.out.println();
        }
    }
    public static void pattern19(int n) {
        /*
        **********
        ****  ****
        ***    ***
        **      **
        *        *
        *        *
        **      **
        ***    ***
        ****  ****
        **********
         */
        int initS = 0;
        // upper-half
        for(int i = 0; i<n; i++) {
            // Stars
            for(int j = 0; j<n-i; j++) {
                System.out.print("*");
            }
            // Spaces
            for(int j = 0; j<initS; j++) {
                System.out.print(" ");
            }
            // Stars
            for(int j = 0; j<n-i; j++) {
                System.out.print("*");
            }
            initS += 2;
            System.out.println();
        }
        // lower-half
        initS = 2*(n-1);
        for(int i = n-1; i>=0; i--) {
            // Stars
            for(int j = 0; j<n-i; j++) {
                System.out.print("*");
            }
            // Spaces
            for(int j = 0; j<initS; j++) {
                System.out.print(" ");
            }
            // Stars
            for(int j = 0; j<n-i; j++) {
                System.out.print("*");
            }
            initS -= 2;
            System.out.println();
        }
    }
    public static void pattern20(int n) {
        /*
        *        *
        **      **
        ***    ***
        ****  ****
        **********
        ****  ****
        ***    ***
        **      **
        *        *
         */
        int initS = 2*(n-1);
        int stars;
        for(int i = 1; i<=2*n-1; i++) {
            if(i<=n) stars = i;
            else stars = 2*n - i;
            // stars
            for(int j = 1; j<=stars; j++) {
                System.out.print("*");
            }
            // space
            for(int j = 1; j<=initS; j++) {
                System.out.print(" ");
            }
            // stars
            for(int j = 1; j<=stars; j++) {
                System.out.print("*");
            }
            if(i<n) initS-=2;
            else initS+=2;
            System.out.println();
        }
    }
    public static void pattern21(int n) {
        /*
        *****
        *   *
        *   *
        *   *
        *   *
        *****
         */
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(i == 0 || j == 0 || i == n-1 || j == n-1)
                    System.out.print("*");
                else 
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void pattern22(int n) {
        /*
        4 4 4 4 4 4 4
        4 3 3 3 3 3 4 
        4 3 2 2 2 3 4 
        4 3 2 1 2 3 4
        4 3 2 2 2 3 4
        4 3 3 3 3 3 4
        4 4 4 4 4 4 4
         */
        /*
        The same matrix can be reduced by subtracting all digits by the greatest number. 
        0 0 0 0 0 0 0
        0 1 1 1 1 1 0
        0 1 2 2 2 1 0
        0 1 2 3 2 1 0 
        0 1 2 2 2 1 0
        0 1 1 1 1 1 0
        0 0 0 0 0 0 0

        now we can notice that the value is nothing by the shortest distance from the edges(top, down, left and right)
         */
        for(int i = 0; i<=2*(n-1); i++) {
            for(int j = 0; j<=2*(n-1); j++) {
                int top = i;
                int down = 2*(n-1)-i;
                int left = j;
                int right = 2*(n-1)-j;
                int minDist = Math.min(Math.min(top, down), Math.min(left, right));
                System.out.print((n-minDist) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Rows: ");
        int n = scanner.nextInt();
        n = 5;  // For testing

        // Running Specific Pattern
        pattern22(n);

        scanner.close();
    }
}