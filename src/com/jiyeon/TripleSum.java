package com.jiyeon;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiyeon on 2017. 7. 27..
 * https://www.careercup.com/question?id=5185811961085952
 */
public class TripleSum {

    private static void findTriplets(int[] given) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i < given.length; i++) {
            for(int j=i+1; j < given.length; j++) {
                if (set.contains(-(given[i]+given[j])))
                    System.out.printf("Found a match (%d, %d, %d)\n", given[i], given[j], -(given[i]+given[j]));
                else
                    set.add(given[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {0, -1, 2, -3, 1};
        int[] input2 = {-1,0,1,2,3};

        findTriplets(input);
        findTriplets(input2);
    }
}
