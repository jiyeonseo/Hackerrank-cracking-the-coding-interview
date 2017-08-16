package com.jiyeon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiyeon on 2017. 8. 16..
 * http://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/
 * Time is O(n).
 */
public class IsomorphicStrings {
    public static boolean isIsomorphic(String[] arr) {
        if(arr[0].length() != arr[1].length()) return false;

        Map<Character, Character> hm = new HashMap<Character, Character>();

        String first = arr[0];
        String second = arr[1];
        for(int i=0; i < first.length(); i++) {
            if(hm.containsKey(first.charAt(i))) {
                if(hm.get(first.charAt(i)) != second.charAt(i)) {
                    return false;
                }
            }else {
                if(hm.containsValue( second.charAt(i))){
                    //if c2 is already being mapped
                    return false;
                }
                hm.put(first.charAt(i), second.charAt(i));
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] sample1 = {"foo" , "bar"};
        String[] sample2 = {"add" , "egg"};

        System.out.println(isIsomorphic(sample1));
        System.out.println(isIsomorphic(sample2));
    }
}
