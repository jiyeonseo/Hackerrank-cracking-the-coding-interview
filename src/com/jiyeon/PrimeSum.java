package com.jiyeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiyeon on 2017. 7. 30..
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

 NOTE A solution will always exist. read Goldbach’s conjecture

 Example:


 Input : 4
 Output: 2 + 2 = 4

 If there are more than one solutions possible, return the lexicographically smaller solution.

 If [a, b] is one solution with a <= b,
 and [c,d] is another solution with c <= d, then

 [a, b] < [c, d]

 If a < c OR a==c AND b < d. 
 */
public class PrimeSum {
    public static boolean isPrime(int n){
        if (n < 2) { // 0 , 1
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static List<Integer> getPrimenumsLessThan(int num){
        List<Integer> arr = new ArrayList<Integer>();
        int count=0;
        for(int i = 0; i <= num; i++){
            if(isPrime(i)){
                arr.add(i);

            }
        }

        return arr;
    }

    public static ArrayList<Integer> primesum(int a) {
        List<Integer> primnums = getPrimenumsLessThan(a);

        ArrayList<Integer> result = new ArrayList<Integer>(2);
        boolean found = false;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<primnums.size(); i++){
            if(found) break;

            map.put(a-primnums.get(i), i);
            for(int j=0; j< primnums.size(); j++) {
                if(map.containsKey(primnums.get(j))) {
                    result.add(primnums.get(map.get(primnums.get(j))));
                    result.add(primnums.get(j));
                    found = true;

                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(primesum(60)); // 7, 53

    }
}
