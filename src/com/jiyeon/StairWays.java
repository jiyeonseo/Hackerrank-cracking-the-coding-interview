package com.jiyeon;

/**
 * Created by jiyeon on 2017. 7. 15..
 */
public class StairWays {
    public static int count(int n) {
        if(n<0) return 0;
        else if(n==0) return 1;
        else {
            return count(n-1) + count(n-2) + count(n-3);
        }
    }


    public static void main(String[] args) {
        /*
        n개의 계단이 있을 때
        한 사람이 1,2,혹은 3개의 계단씩 오른다 했을때 방법을 구하시오
         */
        int n = 3;
        System.out.println(count(n));
    }
}
