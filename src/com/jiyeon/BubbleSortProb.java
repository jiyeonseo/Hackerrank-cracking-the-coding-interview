package com.jiyeon;

/**
 * Created by jiyeon on 2017. 7. 21..
 */
public class BubbleSortProb {

    private static int sortByBubbleSort(int[] arr){
        int numberOfSwap = 0;
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
                    numberOfSwap++;
                }
            }
            lastUnsorted--;
        }
        return numberOfSwap;
    }


    public static void swap(int[] arr, int i, int y) {
        int temp = arr[i];
        arr[i] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3};
        int numberOfSwaps = sortByBubbleSort(input);

        System.out.println("Array is sorted in "+numberOfSwaps+" swaps.");
        System.out.println("First Element: " + input[0]);
        System.out.println("Last Element: "+ input[input.length-1]);

    }
}

