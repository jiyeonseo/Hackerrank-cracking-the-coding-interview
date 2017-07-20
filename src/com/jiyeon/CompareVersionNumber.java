package com.jiyeon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jiyeon on 2017. 7. 21..
 * http://www.programcreek.com/2014/03/leetcode-compare-version-numbers-java/
 *
 */
public class CompareVersionNumber {

    static class VersionComparator implements Comparator<String> {
        @Override
        public int compare(String first, String second) {
            String[] arr1 = first.split("\\."); // 2개의 element 로 나누어져 들어간다
            String[] arr2 = second.split("\\.");

            int i=0;
            while(i<arr1.length || i<arr2.length){
                if(i<arr1.length && i<arr2.length){
                    if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])){
                        return -1;
                    }else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
                        return 1;
                    }
                } else if(i<arr1.length){
                    if(Integer.parseInt(arr1[i]) != 0){
                        return 1;
                    }
                } else if(i<arr2.length){
                    if(Integer.parseInt(arr2[i]) != 0){
                        return -1;
                    }
                }

                i++;
            }

            return 0;
        }
    }
    public static void main(String[] args) {
        String[] versions = {"1.2", "0.1", "13.37", "1.1"};


        VersionComparator checker = new VersionComparator();
        Arrays.sort(versions, checker);

        System.out.println(Arrays.toString(versions)); // //0.1 < 1.1 < 1.2 < 13.37
    }
}
