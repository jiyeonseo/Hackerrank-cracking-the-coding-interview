package com.jiyeon;

/**
 * Created by jiyeon on 2017. 7. 25..
 *
 * # 기둥 1(A)에서 n개의 원반을 기둥 2(B)를 이용하여 기둥 3(C)로 옮겨라
 * 1. 기둥 1(A)에서 n-1개의 원반을 기둥 3(C)을 이용하여 기둥 2(B)에 옮긴다
 * 2. 기둥 1(A)에서 1개의 원반을 기둥 3(C)로 옮긴다.
 * 3. 기둥 2(B)에서 n-1개의 원반을 기둥 1(A)를 이동하여 기둥 3(C)로 옮긴다.
 *
 * Vedio : https://www.youtube.com/watch?v=gmZL5UI6n-8&t=276s
 */
public class TowerOfHanoi {


    public static void moveTower(int n, char from, char inter, char to) {

        if (n == 1) {
            // 원반 하나면 옮기고 바로 끝
            System.out.println("원반 1번 : " + from + " 에서 " + to + "로");
        } else {
            //
            moveTower(n - 1, from, to, inter);
            System.out.println("원반 " + n + "번 : " + from + " 에서 " + to + "로");
            moveTower(n - 1, inter, from, to);
        }


    }
    public static void main(String[] args) {
        int nDisks = 3;

        moveTower(nDisks, 'A', 'B', 'C');
    }
}
