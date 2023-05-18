package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        String s2=br.readLine();
        LongestCommonSubsequence2 obj=new LongestCommonSubsequence2();
        System.out.println(obj.solve(s1,s2));
    }
    public int solve(String A, String B){
        int [][]dp=new int[2][A.length()];
        for(int i=0;i<B.length();i++){
            for(int j=0;j<A.length();j++){
                if(B.charAt(i)==A.charAt(j)){
                    dp[1][j]=1+(j-1>=0?dp[0][j-1]:0);
                }else
                    dp[1][j]=Math.max(j-1>=0?dp[1][j-1]:0,dp[0][j]);
            }
            for(int j=0;j<A.length();j++)
                dp[0][j]=dp[1][j];
        }
        return dp[0][A.length()-1];
    }
}
