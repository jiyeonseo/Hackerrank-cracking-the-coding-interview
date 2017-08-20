package com.jiyeon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiyeon on 2017. 7. 16..
 * [TECHNIQUES/CONCEPTS] Recursion
 * https://www.hackerrank.com/challenges/ctci-fibonacci-numbers
 */
public class FibonacciNumbers {

    public static int fibonacciDP(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;

        int[] val = new int[n+1];
        val[0] = 0;
        val[1] = 1;
        val[2] = 1;
        for(int i = 3; i <= n ; i++) {
            val[n] = fibonacciDP(n-1) + fibonacciDP(n-2);
        }

        return val[n];
    }

    public static int fibonacciMemo(int n) {
        return fibonacciMemo(n, new int[n+1]);
    }

    public static int fibonacciMemo(int n, int[] memo) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;

        if(memo[n] == 0) {
            memo[n] = fibonacciMemo(n-1, memo) + fibonacciMemo(n-2, memo);
        }

        return memo[n]; 
    }
    public static int fibonacci(int n) {
        // Complete the function.
        if(n==0) return 0;
        if(n==1 || n==2) return 1;

        return fibonacci(n-1) + fibonacci(n-2);
    }


    public static void main(String[] args) {
        int input = 6;

        System.out.println(fibonacci(input)); // 8
        System.out.println(fibonacciMemo(input)); // 8
        System.out.println(fibonacciDP(input)); // 8
//        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
//        System.out.println(fibonacciWithMemo2(3)); // 2

    }
}
