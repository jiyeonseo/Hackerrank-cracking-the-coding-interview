package com.jiyeon;

/**
 * Created by jiyeon on 2017. 7. 16..
 * [TECHNIQUES/CONCEPTS] Recursion
 * https://www.hackerrank.com/challenges/ctci-fibonacci-numbers
 */
public class FibonacciNumbers {

    // TODO : tail recusion으로 해봐야지ㅋ

    public static int fibonacci(int n) {
        // Complete the function.
        if(n==0) return 0;
        if(n==1 || n==2) return 1;

        return fibonacci(n-1) + fibonacci(n-2);
    }


    public static void main(String[] args) {
        int input = 3;

        System.out.println(fibonacci(input)); // 2

    }
}
