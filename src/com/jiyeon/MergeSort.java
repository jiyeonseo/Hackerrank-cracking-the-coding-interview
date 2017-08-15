package com.jiyeon;

import java.util.Arrays;

/**
 * Created by jiyeon on 2017. 8. 12..
 * video : https://www.youtube.com/watch?v=KF2j-9iSf4Q&t=70s
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,4,9,2,0};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd) {
            return;
        }

        int middle = (leftStart + rightEnd)/2;

        mergeSort(arr, temp, leftStart, middle);
        mergeSort(arr, temp, middle + 1, rightEnd);
        mergeHalves(arr, temp, leftStart, rightEnd);

    }

    private static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {

        int leftEnd = (leftStart + rightEnd)/2;
        int rightStart = leftEnd+1;
        int size = rightEnd - leftStart +1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd ){
            if(arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            }else {
                temp[index] = arr[right];
                right++;
            }

            index++;

        }

//        (Object src,  int  srcPos, Object dest, int destPos, int length);
        // temp 만들고
        System.arraycopy(arr, left, temp, index, leftEnd-left +1);
        System.arraycopy(arr, right, temp, index, rightEnd-right+1);

        // arr에 다시 복사
        System.arraycopy(temp, leftStart, arr, leftStart, size);

    }
}
