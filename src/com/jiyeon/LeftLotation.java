package com.jiyeon;

import java.util.Arrays;

/**
 * Created by jiyeon on 2017. 8. 16..
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 */
public class LeftLotation {

    public static int[] rotateArray(int[] arr, int d){
        // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
        int n = arr.length;

        // Create new array for rotated elements:
        int[] rotated = new int[n];

        // Object src,  int  srcPos, Object dest, int destPos, int length
        // Copy segments of shifted elements to rotated array:
        System.arraycopy(arr, d, rotated, 0, n - d);
        System.arraycopy(arr, 0, rotated, n - d, d);

        return rotated;
    }


    public static int[] leftLotate(int[] arr, int lotate) {
        int[] newArr = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            int newIndex = i - lotate;
            if(newIndex < 0) newIndex = newIndex+arr.length;

            newArr[newIndex] = arr[i];
        }

        return newArr;
    }
    public static int[] rightLotate(int[] arr, int lotate) {
        int[] newArr = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            int newIndex = i + lotate;
            if(newIndex > arr.length-1) newIndex = newIndex-arr.length;

            newArr[newIndex] = arr[i];
        }

        return newArr;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int lotate = 4;
        System.out.println(Arrays.toString(rightLotate(arr,lotate)));
        System.out.println(Arrays.toString(leftLotate(arr,lotate)));


        System.out.println(Arrays.toString(rotateArray(arr,lotate)));

    }
}
