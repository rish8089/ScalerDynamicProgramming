package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        LongestPalindromicSubstring obj=new LongestPalindromicSubstring();
        System.out.println(obj.longestPalindrome(br.readLine()));
    }
    public String longestPalindrome(String A) {
        int n=A.length();
        boolean [][]dp=new boolean[3][n];
        Arrays.fill(dp[0],true);
        int max=1;
        int pos=0;
        for(int i=0;i<n-1;i++) {
            if(A.charAt(i) == A.charAt(i + 1)){
                max=2;
                pos=i;
                dp[1][i]=true;
            }
        }
        for(int j=2;j<n;j++){
            for(int i=0;i<n-j;i++){
                if(A.charAt(i)==A.charAt(i+j)){
                    dp[2][i]=dp[0][i+1];
                }else
                    dp[2][i]=false;
                if(dp[2][i]){
                    if(max<j+1){
                        max=j+1;
                        pos=i;
                    }
                }
            }
            for(int i=0;i<n;i++){
                dp[0][i]=dp[1][i];
                dp[1][i]=dp[2][i];
            }
        }
        return A.substring(pos,pos+max);
    }
}
