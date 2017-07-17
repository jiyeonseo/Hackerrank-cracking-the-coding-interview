package com.jiyeon;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by jiyeon on 2017. 7. 16..
 * [Dynamic Programming] Coin Change
 *
 * https://en.wikipedia.org/wiki/Dynamic_programming
 * solving a complex problem by breaking it down into a collection of simpler subproblems,
 * solving each of those subproblems just once, and storing their solutions.
 * The next time the same subproblem occurs, instead of recomputing its solution,
 * one simply looks up the previously computed solution,
 * thereby saving computation time at the expense of a (hopefully) modest expenditure in storage space.
 * (Each of the subproblem solutions is indexed in some way, typically based on the values of its input parameters,
 * so as to facilitate its lookup.)
 * The technique of storing solutions to subproblems instead of recomputing them is called "memoization".
 *
 *
 *
 * The process of solving easier to solve sub-problems and building up the answer from that
 *
 * explain video : https://www.youtube.com/watch?v=jaNZ83Q3QGc
 * hackerRank video : https://www.youtube.com/watch?v=sn0DWI-JdNA
 */
public class CoinChange {

    public static long makeChange1(int[] coins, int money) {
//        explain video : https://www.youtube.com/watch?v=jaNZ83Q3QGc
        Arrays.sort(coins);

        int[] combinations = new int[money+1];

        combinations[0] = 1;

        for(int coin : coins) {
            for(int i=1; i < combinations.length; i++) {
                if(i >= coin) {
                    combinations[i] += combinations[i-coin];
                }
            }
        }

        return combinations[money];
    }

    public static long makeChange2(int[] coins, int money) {
//         hackerRank video : https://www.youtube.com/watch?v=sn0DWI-JdNA
        return makeChange2(coins, money, 0);
    }

    public static long makeChange2(int[] coins, int money, int index) { // before using memoization
        if(money == 0) return 1;
        if(index >= coins.length) return 0;

        int amountWithCoin = 0;
        long ways = 0;
        while (amountWithCoin <= money) {
            int remaining = money - amountWithCoin;
            ways += makeChange2(coins, remaining, index+1);
            amountWithCoin += coins[index];
        }
        return ways;
    }

    public static long makeChange3(int[] coins, int money) {
//         hackerRank video : https://www.youtube.com/watch?v=sn0DWI-JdNA
        return makeChange3(coins, money, 0, new HashMap<String, Long>());
    }

    public static long makeChange3(int[] coins, int money, int index, HashMap<String, Long> memo) { // before using memoization
        if(money == 0) return 1;
        if(index >= coins.length) return 0;

        String key = money + "-" + index;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int amountWithCoin = 0;
        long ways = 0;
        while (amountWithCoin <= money) {
            int remaining = money - amountWithCoin;
            ways += makeChange3(coins, remaining,index+1, memo);
            amountWithCoin += coins[index];
        }

        memo.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        int money = 10;
        int[] coins = {2,5,3,6};
        System.out.println(makeChange1(coins, money)); // 5 공식
        System.out.println(makeChange2(coins, money)); // 5 HackerRank PD
        System.out.println(makeChange3(coins, money)); // 5 HackerRank PD + Memoization
    }
}
