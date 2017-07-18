package com.jiyeon;

/**
 * Created by jiyeon on 2017. 7. 18..
 * [Recursion] Davis' Staircase
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase
 *
 *
 * hackerrank video : https://www.youtube.com/watch?v=eREiwuvzaUM
 * python video : https://www.youtube.com/watch?v=AjU6sUr21_w&index=21&list=PLVNY1HnUlO24RlncfRjfoZHnD0YWVsvhq
 *
 */
public class StairCase {
    private static int getWaysWithMemo(int n) {
        return getWaysWithMemo(n, new int[n+1]);
    }
    private static int getWaysWithMemo(int n, int[] memo) { // Memoization을 이용하여 복잡도를 낮춤
        if(n < 0) {
            return 0;
        }
        else if(n==0) {
            return 1;
        }
        if(memo[n] == 0) {
            memo[n] = getWaysWithMemo(n-1, memo) + getWaysWithMemo(n-2, memo) + getWaysWithMemo(n-3, memo);
        }
        return memo[n];
    }

    private static int getWays1(int n) { // --> 위 방법으로 하면 hackerRank에서 몇몇 test case 타임아웃남
        // f(n) = f(n-1) + f(n-2) + f(n-3)
        if(n < 0) {
            return 0;
        }
        else if(n==0) {
            return 1;
        }
        else {
            return getWays1(n-1) + getWays1(n-2) + getWays1(n-3);
        }
    }


    public static void main(String[] args) {
        System.out.println(getWays1(1)); // 1
        System.out.println(getWays1(3)); // 4
        System.out.println(getWays1(7)); // 44

        System.out.println(getWaysWithMemo(1)); // 1
        System.out.println(getWaysWithMemo(3)); // 4
        System.out.println(getWaysWithMemo(7)); // 44

    }
}
