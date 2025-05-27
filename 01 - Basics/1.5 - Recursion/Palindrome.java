// Leetcode -> 125. Valid Palindrome (https://leetcode.com/problems/valid-palindrome/)

import java.util.Scanner;

public class Palindrome {

    // Brute Force Approach
    /*
     * Time Complexity - O(n)
     */
    public static void approach1(String s) {
        s = s.toLowerCase();
        String newStr = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122 || s.charAt(i) >= 48 && s.charAt(i) <= 57)
                newStr += s.charAt(i);
        }

        String revStr = "";
        for (int i = 0; i < newStr.length(); i++) {
            revStr = newStr.charAt(i) + revStr;
        }

        if (newStr.equalsIgnoreCase(revStr))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }

    // Better Approach
    /*
     * Time Complexity - O(n)
     */
    public static void approach2(String s) {
        if (s.isEmpty()) {
            System.out.println("Palindrome");
            return;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            char schar = s.charAt(start);
            char echar = s.charAt(end);
            if (!Character.isLetterOrDigit(schar))
                start++;
            else if (!Character.isLetterOrDigit(echar))
                end--;
            else {
                if (Character.toLowerCase(schar) != Character.toLowerCase(echar)) {
                    System.out.println("Not Palindrome");
                    return;
                }
                start++;
                end--;
            }
        }
        System.out.println("Palindrome");
    }

    // Recursive Optimal Approach
    /*
     * Time Complexity - O(n/2)
     */
    public static boolean approach3(int i, String s) {
        if(i>=s.length()/2) return true;
        char schar = s.charAt(i);
        char echar = s.charAt(s.length()-i-1);
        if(Character.toLowerCase(schar) != Character.toLowerCase(echar)) return false;
        return approach3(i+1, s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        approach2(s);
        System.out.println(approach3(0, s));
        sc.close();
    }
}
