package com.jiyeon;

import java.util.*;

/**
 * Created by jiyeon on 2017. 7. 22..
 * http://www.programcreek.com/2014/03/leetcode-candy-java/
 *
 * 아이들에게 사탕을 나누어 준다.
 *
 * 1. 각각의 아이들은 rating을 가지고 있다
 * 2. 적어도 한 아이당 1개 이상의 사탕을 주어야 하고
 * 3. rating이 높은 아이는 사탕을 주변(앞,뒤) 아이보다 더 받아야 한다.
 *
 * 그때 내가 가지고 있어야 할 최소한의 사탕의 갯수는?
 * Time complexity : O(n)
 */
public class Candy {

    public static int candies3(int[] ratings) {

//        code : https://discuss.leetcode.com/topic/8208/one-pass-constant-space-java-solution/2
//        description : http://www.allenlipeng47.com/blog/index.php/2016/07/21/candy/
        if (ratings == null || ratings.length == 0) return 0;

        int total = 1, prev = 1, countDown = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i-1]) {
                if (countDown > 0) {
                    total += countDown*(countDown+1)/2; // arithmetic progression
                    if (countDown >= prev) total += countDown - prev + 1;
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i-1] ? 1 : prev+1;
                total += prev;
            } else countDown++;
        }
        if (countDown > 0) { // if we were descending at the end
            total += countDown*(countDown+1)/2;
            if (countDown >= prev) total += countDown - prev + 1;
        }
        return total;
    }


    public static int candies2(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int[] candies = new int[ratings.length];
        candies[0] = 1;

        //from let to right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                // if not ascending, assign 1
                candies[i] = 1;
            }
        }

        int result = candies[ratings.length - 1];

        //from right to left
        for (int i = ratings.length - 2; i >= 0; i--) {
            int cur = 1;
            if (ratings[i] > ratings[i + 1]) {
                cur = candies[i + 1] + 1;
            }

            result += Math.max(cur, candies[i]);
            candies[i] = cur;
        }



        return result;
    }

    public static int[] candies(int[] rating){
        int[] children = new int[rating.length];

        children[0] = 1;

        // from left to right
        for(int i = 0;i < children.length-1 ; i++) {
            if(rating[i] < rating[i+1]) {
                children[i+1] = children[i] +1;
            }else {
                children[i+1] = 1;
            }
        }


        // from right to left
        for(int i = children.length-2 ;i > 0 ; i--) {
            if(rating[i] > rating[i+1]) {
                children[i] = children[i+1] +1;
            }
        }

        return  children;
    };

    public static void main(String[] args) {
        int[] rating = {1,2,5,5,4,3,10,7};

        int[] result = candies(rating);

        System.out.println(Arrays.toString(result));
        int num = 0;
        for(int i =0; i< result.length; i++ ){
            num += result[i];
        }

        System.out.println("my solution : " +num);
        System.out.println("solution 2 : " +candies2(rating));
        System.out.println("solution 3 : " +candies3(rating));


    }
}
