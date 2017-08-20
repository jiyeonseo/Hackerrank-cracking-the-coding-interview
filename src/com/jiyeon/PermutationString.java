package com.jiyeon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiyeon on 2017. 8. 20..
 * 주어진 문자열의 순열 (permutation) 을 모두 구하라
 * video : https://www.youtube.com/watch?v=WHR1trMsvOE
 * Time complexity : O(n!)
 */
public class PermutationString {
    public static void main(String[] args) {
        String input = "abcd"; // n!의 갯수가 생김. 24개
        List<String> result = getPerm(input);
        System.out.println(result.toString());
    }

    private static List<String> getPerm(String input) {
        if(input == null) return null;

        List<String> permutations = new ArrayList<String>();

        if(input.length() == 0) { // 아무것도 없을 경우
            permutations.add(""); // 초기화
            return permutations;
        }

        char first = input.charAt(0);
        String remainders = input.substring(1);

        List<String> words =  getPerm(remainders); // recursive

        for(String word : words) {
            for(int i=0; i<= word.length(); i++) {
                String s = insertCharAt(word, first, i);
                permutations.add(s);
            }
        }

        return permutations;


    }

    private static String insertCharAt(String word, char c, int i) {

        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;

    }
}
