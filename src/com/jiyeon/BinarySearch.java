package com.jiyeon;

/**
 * Created by jiyeon on 2017. 8. 12..
 */
public class BinarySearch {
    // 2. iterasive
    private static boolean iterBinarySearch(int[] arr, int target){

        int left = 0;
        int right = arr.length-1;

        while (left <= right) {
            int mid = (left + right)/2;
            if(arr[mid] == target) {
                return true;
            }
            else if(target < arr[mid]){
                right = mid -1;
//                return recurBinarySearch(arr, target, left, mid -1);
            }
            else {
                left = mid + 1;
//                return recurBinarySearch(arr, target, mid+1, right);
            }
        }

        return false;
    }

    // 1. recursive
    private static boolean recurBinarySearch(int[] arr, int target, int left, int right){
        if(left > right ) return false;

        int mid = ( left + right ) /2;
        if(arr[mid] == target) return true;
        else if(target < arr[mid]) return recurBinarySearch(arr, target, left, mid -1);
        else return recurBinarySearch(arr, target, mid+1, right);


    }

    private static boolean findByBinarySearch(int[] arr, int target){
        return recurBinarySearch(arr, target, 0, arr.length -1);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,9,10};
        int target = 2;
        boolean result = findByBinarySearch(arr, target);
        boolean result2 = iterBinarySearch(arr, target);
        System.out.println(result);
        System.out.println(result2);
    }
}
