package com.jiyeon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jiyeon on 2017. 7. 21..
 * http://www.programcreek.com/2013/02/leetcode-permutations-java/
 *
 */
public class Permutation {
    private static ArrayList<ArrayList<Integer>> permute(int[] num){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); // 일단 결과값을 넣을 ArrayList 세팅

        //일단 빈거 하나 추가 해놓고 시작
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) { // 갯수만큼 돈다.
            //list of list in current iteration of the array num
            // 현재 iteration 값을 넣어줄 current 생성
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size()+1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);

                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);

                    System.out.println(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<ArrayList<Integer>>(current);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] input = {1,2,3}; // 갯수는 총 3! = 3 * 2 * 1 = 6
        ArrayList<ArrayList<Integer>> permutations = permute(input);
        System.out.println(permutations);


    }
}
