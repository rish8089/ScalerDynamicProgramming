package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        LongestPalindromicSubsequence obj=new LongestPalindromicSubsequence();
        System.out.println(obj.solve(br.readLine()));
    }
    public int solve(String A) {
        StringBuilder sb=new StringBuilder(A);
        String B=sb.reverse().toString();
        return lcs(A,B);
    }
    private int lcs(String A, String B){
        int [][]dp=new int[2][A.length()];
        for(int i=0;i<A.length();i++){
            for(int j=0;j<B.length();j++){
                if(A.charAt(i)==B.charAt(j))
                    dp[1][j]=1+(j-1>=0?dp[0][j-1]:0);
                else
                    dp[1][j]=Math.max(dp[0][j],j-1>=0?dp[1][j-1]:0);
            }
            for(int j=0;j<A.length();j++)
                dp[0][j]=dp[1][j];
        }
        return dp[0][A.length()-1];
    }
}
