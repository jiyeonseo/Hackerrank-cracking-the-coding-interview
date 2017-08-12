package com.jiyeon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiyeon on 2017. 8. 12..
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor
 * video : https://www.youtube.com/watch?v=Ifwf3DBN1sc
 */
public class IceCreamParlor {
    // 방법 1. twosum
    private static int[] getSum(int sum, int[] coins){

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for(int i=0;i<coins.length;i++) {
            if(hm.containsKey(coins[i])){
                result[0] = hm.get(coins[i]);
                result[1] = i;
            }else {
                hm.put(sum-coins[i], i);
            }
        }

        return result;
    }

    // 2. binary search
    private static int[] getSumWithBinarySearch(int sum, int[] coins){

        Arrays.sort(coins);

        int middle = coins.length / 2 ;
        int right = middle;
        int left = 0;

        while(left < middle && right <coins.length) {
            int s = coins[left] + coins[right];
            if(s == sum) {
                break;
            }else if(s < sum){
                if(right < coins.length) right += 1;
                else if(left < middle) left += 1;
            }else if(s > sum){
                right -=1 ;
            }

        }

        System.out.println( " " + left + " " + right );
        int[] result = {left, right};
        return result;

    }

    // 2. binary search
    private static int[] findChoices(int money, int[] menu) {
        int[] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);

        for(int i=0; i< sortedMenu.length; i++) {
            int complement = money - sortedMenu[i];
            int location = Arrays.binarySearch(sortedMenu, i+1, sortedMenu.length, complement);
            // the array to be searched, from index, last index, the value to be searched for

            if(location >=0 && location < sortedMenu.length && sortedMenu[location] == complement) {
                int[] indices = getIndiciseFromArray(menu, sortedMenu[i], complement);
                return indices;
            }
        }

        return null;
    }

    private static int[] getIndiciseFromArray(int[] menu, int value1, int value2) {
        int index1 = indexOf(menu, value1, -1);
        int index2 = indexOf(menu, value2, index1);

        int[] result = { Math.min(index1, index2), Math.max(index1, index2)};

        return result;
    }

    private static int indexOf(int[] menu, int value, int excludeThis) {
        for(int i = 0; i < menu.length; i++) {
            if(menu[i] == value && i != excludeThis) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int sum = 4;
//        int[] coins = {1,4,5,3,2};

        int sum = 10;
        int[] coins = {1,7,5,4,2,10,5};

        String result = "";
        for(int r : findChoices(sum,coins)) {
            result += (r+1) + " ";
        }
        System.out.println(result); //3 7

    }
}
