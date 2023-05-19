package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestPalindromicSubsequence2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        LongestPalindromicSubsequence2 obj=new LongestPalindromicSubsequence2();
        System.out.println(obj.solve(br.readLine()));
    }
    public int solve(String A){
        int n=A.length();
        if(n==1)
            return 1;
        int [][]dp=new int[3][n];
        Arrays.fill(dp[0], 1);
        for(int i=0;i<n-1;i++)
            dp[1][i]=A.charAt(i)==A.charAt(i+1)?2:1;
        for(int j=2;j<n;j++){
            for(int i=0;i<n-j;i++){
                //check range  [i,i+j]
                if(A.charAt(i)==A.charAt(i+j))
                    dp[2][i]=2+dp[0][i+1];
                else
                    dp[2][i]=Math.max(dp[1][i+1],dp[1][i]);
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = dp[1][i];
                dp[1][i] = dp[2][i];
            }
        }
        return dp[1][0];
    }
}
