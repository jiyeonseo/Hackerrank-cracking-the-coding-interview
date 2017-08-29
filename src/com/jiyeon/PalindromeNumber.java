package com.jiyeon;

/**
 * Created by jiyeon on 2017. 8. 30..
 * problem : https://leetcode.com/problems/palindrome-number
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int a = 11011;
        System.out.println(isPalindrome(a));
    }
    public static boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            System.out.println("rev1 : " + rev);
            rev = rev*10 + x%10;
            System.out.println("rev2 : " + rev);
            x = x/10;
            System.out.println("x : " + x);
        }
        System.out.println("x : " + x + ", rev : " + rev);
        return (x==rev || x==rev/10);

    }
}
