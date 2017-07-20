package com.jiyeon;

import java.util.Arrays;

/**
 * Created by jiyeon on 2017. 7. 19..
 * [Sorting] bubble-sort
 * https://www.hackerrank.com/challenges/ctci-bubble-sort
 *
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        boolean isSorted = false; // 처음은 정렬flag값을 false로 둔다
        while(!isSorted) {
            isSorted = true; // 일단 시작할때는 정렬되었다 치고
            for(int i = 0; i < arr.length-1 ; i++) { // 맨 마지막까지 가게되면 ArrayIndexOutOfBoundsException 그러므로 -1 해줘야함
                if(arr[i] > arr[i+1]){ // 정렬해야할게 있다면
                    swap(arr, i, i+1);
                    isSorted = false;  // flag를 false로 만들어 준다
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr) { // 조금 더 optimize를 해보자 
        boolean isSorted = false;
        // 첫번째 한번 쭉 돌고나면 가장 큰 값은 정렬 맨 마지막에 가있다.
        // 즉. 끝에서는 다시 돌 필요가 없다.
        int lastUnsorted = arr.length-1;
        while(!isSorted) {
            isSorted = true;
            for(int i = 0; i < lastUnsorted ; i++) {
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
    }


    public static void swap(int[] arr, int i, int y) {
        int temp = arr[i];
        arr[i] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] input = {1,3,5,7,2,4,6,8};
        bubbleSort2(input);
        System.out.println(Arrays.toString(input));
    }
}
