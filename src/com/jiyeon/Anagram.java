package com.jiyeon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiyeon on 2017. 7. 22..
 * Anagram :
 */
public class Anagram {
    final static int ALPHABET_NUMBER = 26;

    // if unicode character, not enought with 26
    public static boolean isAnagram3(String first, String second) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0; i < first.length(); i++) {
            char ch = first.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            }else {
                map.put(ch, 1);
            }
        }

        for(int i=0; i < second.length(); i++) {
            char ch = second.charAt(i);
            if(map.containsKey(ch)) {
                if(map.get(ch) == 1) {
                    map.remove(ch);
                }else {
                    map.put(ch, map.get(ch)-1);
                }
            }else {
                map.put(ch, -1);
            }
        }

        if(map.size() > 0 ) return false;
        return true;

    }

    public static boolean isAnagram2(String first, String second) {
        if(first.length() != second.length()) return false;

        int[] arr = new int[26];

        for(int i=0;i<first.length();i++){

            arr[first.charAt(i)-'a'] ++;
            arr[second.charAt(i)-'a'] --;
        }

        for(int a : arr) {
            if(a != 0) {
                return false;
            }
        }
        return true;
    }

    public static String sorting(String param) {
        char[] chars = param.trim().toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static boolean isAnagram(String first, String second){
        return sorting(first).equals(sorting(second));
    }
    public static void main(String[] args) {
        String first = "COOKIE";
        String second = "EICOOK";

        System.out.println(isAnagram(first, second));
        System.out.println(isAnagram2(first.toLowerCase(), second.toLowerCase()));
        System.out.println(isAnagram3(first, second));
//        System.out.println(isAnagram(first, second)); // true
    }
}
