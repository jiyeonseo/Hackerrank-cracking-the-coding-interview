package com.jiyeon;

/**
 * Created by jiyeon on 2017. 8. 19..
 * 5개의 약병이 있는데 4개는 1그램, 1개는 1.1그램이다
 * 정확한 저울 단 한번을 써서 1.1그램이 들어있는 약병을 찾아라.
 */
public class FindHeavy {

    public static void main(String[] args) {
        double[] arr = {1, 1, 1.1, 1, 1};
        System.out.println(findHeavy(arr));
    }

    private static int findHeavy(double[] arr) {
        if(arr== null || arr.length ==0 ) return 0;

        double expect = getSum(arr); // 각병에서 알약을 index값의 갯수만큼 뺏을 때의 예측값. 15
        // #1에서 한개, #2에서 2개...
        double sum = 0;

        for(int i=0; i<arr.length; i++) { // 각병에서 알약을 index값의 갯수만큼 뺏을 때.
            sum += ( arr[i] * (i+1) ) ; // 15.3
        }

        double diff = sum - expect; // 0.3

        double n = diff / 0.1 ; // 3 // 차이값을 한 알약의 무거운 만큼 나눠주면 index값이 나온다. 

        return (int) n  ; // 3
    }

    private static double getSum(double[] arr) {

        double sum = 0;

        for(int i=1; i<=arr.length; i++) {
            sum += i;
        }

        return sum;
    }
}
