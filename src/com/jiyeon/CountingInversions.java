package com.jiyeon;

/**
 * Created by jiyeon on 2017. 8. 15..
 * https://www.hackerrank.com/challenges/ctci-merge-sort
 * video : https://www.youtube.com/watch?v=k9RQh21KrH8
 * Inversion count for an array indicates : How far (or close) the array is from being sorted
 * Best case : Sorted
 * Worst case : Reversed
 *
 * Video1 : https://www.youtube.com/watch?v=4IvYaOY8Pxw
 * Video2 : https://www.youtube.com/watch?v=PLkuid82dbc
 *
 * merge sort : time complexity : O(n log n)
 */
public class CountingInversions {


    private static long countInversions(int[] arr) {
        int[] aux = arr.clone();
        return countInversions(arr, 0, arr.length - 1, aux);
    }

    private static long countInversions(int[] arr, int lo, int hi, int[] aux) {
        if (lo >= hi) return 0;

        int mid = lo + (hi - lo) / 2;

        long count = 0;
        count += countInversions(aux, lo, mid, arr);
        count += countInversions(aux, mid + 1, hi, arr);
        count += merge(arr, lo, mid, hi, aux);

        return count;
    }

    private static long merge(int[] arr, int lo, int mid, int hi, int[] aux) {
        long count = 0;
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid || j <= hi) {
            if (i > mid) {
                arr[k++] = aux[j++];
            } else if (j > hi) {
                arr[k++] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
                count += mid + 1 - i;
            }
        }

        return count;
    }

    private static int getSwap1(int[] arr){ // Time complexity : O(n^2)
        if(arr == null || arr.length < 2) return 0;

        int count = 0;
        int index = 0;
        while(index <= (arr.length -2) ) {
            if(arr[index] > arr[index+1]) {
                int temp = arr[index];
                arr[index] = arr[index+1];
                arr[index+1] = temp;

                count++;
                index = 0;
            }else {
                index++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] sample1 = {1, 1, 1, 2, 2};
        int[] sample2 = {2, 1, 3, 1, 2};
        int[] sample3 = {2, 4, 1, 3, 5};
        System.out.println(getSwap1(sample2)); // 4

        System.out.println(countInversions(sample3)); //3

    }
}
