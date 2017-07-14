package com.jiyeon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiyeon on 2017. 7. 15..
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
public class RansomNote {
    //
    private static String checkRansomNote(String[] magazine, String[] ransom) {
        Map<String, Integer> hm = new HashMap<String, Integer>();

        for(String ransomElemt : ransom ){ // ransom이 가지고 있는 원소들로 HashMap을 만든다
            if(hm.containsKey(ransomElemt)) { // 만약 이미 있는 값이면 value값을
                hm.put(ransomElemt, hm.get(ransomElemt) + 1); // 하나 더 증가
            }else  { // 없었으면
                hm.put(ransomElemt, 1); // 1로 초기화
            }
        }

        for(String magazineElem : magazine) { // 이제 magazin으로
            if(hm.containsKey(magazineElem)) { // ransom에 가지고 있으면
                hm.put(magazineElem, hm.get(magazineElem) -1 ); // 그 값에서 -1을 해준다.
            }
        }
        String result = "Yes";

        for(int i : hm.values()){ // 해쉬맵의 원소들을 돌면서 값 체크
            if(i > 0) { // 한번도 안쓰였다면 ++ 만 생겼을 테니
                result = "No";
                break;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String[] magazin = "two times three is not four".split(" "); // magazin으로 들어온 string값들로
        String[] ransom = "two times two is four".split(" ");// ransom이 이루어 졌는지 확인하라
        System.out.println(checkRansomNote(magazin, ransom)); // No


        /*
        CASE.
            magazin = "h ghq g xxy wdnr anjst xxy wdnr h h anjst wdnr"
            ransom = "h ghq"

            output = Yes
         */
    }
}
