package com.jiyeon;

import java.util.Arrays;

/**
 * Created by jiyeon on 2017. 7. 22..
 */
public class Anagram {
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

        System.out.println(isAnagram(first, second)); // true
    }
}
