package com.jiyeon;

import java.util.Hashtable;

/**
 * Created by jiyeon on 2017. 7. 15..
 * https://www.hackerrank.com/challenges/ctci-making-anagrams
 */
public class MakingAnagrams {
    public static int numberNeeded(String first, String second) {
        int[] resultArr = new int[26]; // 알파벳 전체 길이만큼 array를 만들고
        // index 0 이 a
        // index 1 이 b
        // ...

        for( char x : first.toCharArray()) {
            resultArr[x-'a']++; // 해당 알파벳의 index의 값을 +1 씩
        }
        for( char y : second.toCharArray()) {
            resultArr[y-'a']--; // 해당 알파벳의 index의 값을 -1 씩
        }

        // 만약 같은 알파벳이 있었다면 +1-1되어서 0이 되었을 것

        Hashtable<String, Boolean> ht = new Hashtable<String, Boolean>();
        int result = 0;
        for(int i = 0; i < resultArr.length; i++ ) {
            result += Math.abs((resultArr[i])); // 음수 일수도 있으므로 Math.abs를 이용해 절대값으로 만든다.
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "cde";
        String b = "abc";
        System.out.println(numberNeeded(a, b));
    }
}
