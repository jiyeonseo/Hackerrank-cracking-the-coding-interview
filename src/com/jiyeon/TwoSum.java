package com.jiyeon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiyeon on 2017. 7. 15..
 */
public class TwoSum {

    private static int[] findTwoSum(int[] arr, int target) {
        int[] result = new int[2]; // 결과 값을 받을 int array

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int elem : arr) {
            if(hm.containsKey(elem)){ // 만약 이 값을 키로 가지고 있다면 두 값을 더하면 target 값이 나옴
                result[0] = hm.get(elem);
                result[1] = elem;
            }else {
                hm.put(target - elem, elem); // 타겟에서 요소를 뺀 값을 키로 value는 그 요소값으로 
            }
        }

        /*

        int[] intarr = {3,7,2,1}; // 이 array에서 두 값을 더하여
        int target = 9; // 이 타겟을 만들수 있는 요소를 찾으라

            HashMap

                Key | Value
              --------------
                6   :   3
                2   :   7
                ...
         */

        return result;
    }
    public static void main(String[] args) {

        int[] intarr = {3,7,2,1}; // 이 array에서 두 값을 더하여
        int target = 9; // 이 타겟을 만들수 있는 요소를 찾으라

        int[] result = findTwoSum(intarr, target);
        for(int x : result) {
            System.out.println(x);
        }
    }
}
