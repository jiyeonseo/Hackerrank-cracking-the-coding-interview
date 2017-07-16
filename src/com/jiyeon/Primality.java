package com.jiyeon;

/**
 * Created by jiyeon on 2017. 7. 16..
 * [TECHNIQUES/CONCEPTS] https://www.hackerrank.com/challenges/ctci-big-o
 * 소수 인지 구하시오
 */
public class Primality {

    public static int gcd(int a ,int b){
        if(b ==0) return a;
        else return gcd(b, a%b);
    }

    public static boolean isPrime(int n){

        if (n < 2) { // 0 , 1
            return false;
        }
        int sqrt = (int) Math.sqrt(n); // 루트 https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Math/sqrt
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // 최대공약수
        System.out.println(gcd(5,15));
        System.out.println(gcd(30,12)); // 6

        // 소수
        System.out.println(isPrime(1000000007));  // true
        System.out.println(isPrime(12));  // false

    }
}
