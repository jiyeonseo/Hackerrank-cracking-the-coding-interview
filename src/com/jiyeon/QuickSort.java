package com.jiyeon;

import java.util.Arrays;

/**
 * Created by jiyeon on 2017. 7. 21..
 * vedio : https://www.youtube.com/watch?v=SLauY6PpjW4
 */
public class QuickSort {
    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
//        int middle = low + (high - low) / 2;
        int middle = (low + high)/2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }
    public static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while(array[left] < pivot ){ // 왼쪽 index가 아직 중간값(pivot) 보다 작다면 계쏙
                left ++;
            }

            while (array[right] > pivot) { // 오른쪽 index가 아직 중간(pivot) 보다 크다면 계속 움직여라
                right--;
            }

            if(left > right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }


        return left; // partition point
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;

    }

    public static void main(String[] args) {
        int[] test = {1,5,2,4,3};
        quickSort(test);
        System.out.println(Arrays.toString(test)); // [1,2,3,4,5]
    }
}
