package com.jiyeon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jiyeon on 2017. 8. 16..
 */
public class UniqueCharacter {

    public static boolean checkUnique2(String str) {
        // 만약 ascii 라면 최대 256 개 이니까
        if(str.length() > 256) return false;

        char[] cArr = str.toCharArray();
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        boolean result = true;
        for(int i = 0; i < cArr.length; i++) {
            if(hm.containsKey(cArr[i])) {
                result = false;
                break;
            }else {
                hm.put(cArr[i], i);
            }
        }

        return result;



    }

    public static boolean checkUnique1(String str) {

        char[] cArr = str.toCharArray();

        HashSet hs = new HashSet();
        for(char c : cArr) {
            hs.add(c);
        }

        return hs.size() == cArr.length;
    }

    public static void main(String[] args) {
        String a = "ABCD";
        String b = "ABAC";
        System.out.println(checkUnique1(a)); // true
        System.out.println(checkUnique1(b)); // false
        System.out.println(checkUnique2(a)); // true
        System.out.println(checkUnique2(b)); // false
    }
}
