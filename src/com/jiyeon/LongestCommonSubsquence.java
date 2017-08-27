package com.jiyeon;

/**
 * Created by jiyeon on 2017. 8. 26..
 * problem : https://www.programcreek.com/2014/04/longest-common-subsequence-java/
 * video : https://www.youtube.com/watch?v=NnD96abizww
 *
 * 두개의 String이 있다고 치자.
 * String p = "BATD";
 * String q = "ABACD";
 * -> "BAD"
 */
public class LongestCommonSubsquence {
    public static void main(String[] args) {

        String p1 = "ABCD";
        String q1 = "AEBD";

        String p = "BATD";
        String q = "ABACD";
        String result = getLongestCommonSubsequence(p,q) ;
        String result2 = getLongestCommonSubsequence(p1,q1) ;
        System.out.println(result); // "BAD"
        System.out.println(result2); // "ABD"

        int result3 = getLongestCommonSubsequenceDP(p,q) ;
        System.out.println(result3);
    }

    private static String getLongestCommonSubsequence(String p, String q) {

        char[] pChar = p.toCharArray();
        char[] qChar = q.toCharArray();

        int i =0, j=0;
        String result = "";
        int resultCount = 0;
        while(i < p.length() && j < q.length()) {
            int jidx = 0;
            if(pChar[i] == qChar[j]) {
                resultCount ++;
                result += pChar[i];
                i ++;
                j ++;
                jidx = j;
            }else {
                if(j == q.length()-1) {
                   i ++;
                   j = jidx;
                }else {
                   j++;
                }
            }
        }
        System.out.println("resultCount : " +  resultCount);
        return result;
    }

    // https://www.programcreek.com/2014/04/longest-common-subsequence-java/
    public static int getLongestCommonSubsequenceDP(String a, String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

}
