package com.jiyeon;

/**
 * Created by jiyeon on 2017. 7. 16..
 */
public class Factorial {

    public static int fact(int n, int acc) {
        if(n==0) return acc;

        return fact(n-1, acc * n);
    }
    
    public static void main(String[] args) {
        // 1! = 1
        // 2! = 2
        // 3! = 6
        // 4! = 24
        // ...

        int input = 4;
        System.out.println(fact(input,1)); // 24

    }
}
