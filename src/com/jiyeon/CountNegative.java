package com.jiyeon;

/**
 * Created by jiyeon on 2017. 8. 20..
 * video : https://www.youtube.com/watch?v=5dJSZLmDsxk
 */
public class CountNegative {
    public static void main(String[] args) {
        int[][] matrix = {{-3,-2,-1,1},{2,2,3,4},{-5,-4,7,8}};

        System.out.println(getNegativeCount(matrix));
        System.out.println(getNegativeCount2(matrix));

    }

    private static int getNegativeCount(int[][] matrix) {
        int count = 0;
        int row = matrix.length;
        int column = matrix[0].length;

        for(int i=0; i <row; i++){
            for(int j=0; j< column; j++){
                if(matrix[i][j] <0){
                    count ++;
                }
            }
        }

        return count;
    }

    private static int getNegativeCount2(int[][] matrix) {
        int count = 0;
        int row = matrix.length;
        int column = matrix[0].length;

        int i = 0;
        int j = column-1;
        while(i < row && j >= 0) {
            if(matrix[i][j] < 0) {
                count += (j+1);
                i++;
                j = column-1;

            }else {
                if(j == 0){
                    i++;
                    j = column-1;
                }else {
                    j--;
                }

            }

        }

        return count;

    }
}
