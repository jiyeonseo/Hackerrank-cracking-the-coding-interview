package com.jiyeon;

import java.util.*;

/**
 * Created by jiyeon on 2017. 7. 17..
 * [Bit Manipulation] Lonely Integer
 * https://www.hackerrank.com/challenges/ctci-lonely-integer
 */
public class LonelyInteger {
    public static int getLonelyInteger2(int[] arr) { // hackerRank Solution
        // 들어온 숫자들을 이진법으로 한다음  자리수 마다 더하면 다 더한 값이 unique한 숫자
        int result = 0;

        for(int value : arr) {
            result ^= value;  //result = result ^ value;
        }

        return result;

    }
    public static List<Integer> getLonelyInteger(int[] arr) { // my Solution
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int elem : arr){
            if(hm.containsKey(elem)){
                hm.remove(elem);
            }else {
                hm.put(elem, elem);
            }
        }

        return new ArrayList<Integer>(hm.values());
    }
    public static void main(String[] args) {
        int[] a = {1,1,2};
        int[] b = {0,0,1,2,1};

        int[] c = {0,0,1,2,2,1,3};
        System.out.println(getLonelyInteger(a)); // 2
        System.out.println(getLonelyInteger(b)); // 2
        System.out.println(getLonelyInteger(c)); // 3
        System.out.println(getLonelyInteger2(c)); // 3
    }
}
