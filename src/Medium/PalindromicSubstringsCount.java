package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PalindromicSubstringsCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        PalindromicSubstringsCount obj=new PalindromicSubstringsCount();
        System.out.println(obj.solve(str));
    }
    public int solve(String A) {
        int n=A.length();
        boolean [][]dp=new boolean[3][n];
        Arrays.fill(dp[0],true);
        int cnt=n;
        for(int i=0;i<n-1;i++) {
            dp[1][i] = A.charAt(i) == A.charAt(i + 1);
            if(dp[1][i])
                cnt++;
        }
        for(int j=2;j<n;j++){
            for(int i=0;i<n-j;i++){
                //range is [i,i+j]
                dp[2][i]=A.charAt(i)==A.charAt(i+j) && dp[0][i+1];
                if(dp[2][i])
                    cnt++;
            }
            for(int i=0;i<n;i++) {
                dp[0][i] = dp[1][i];
                dp[1][i] = dp[2][i];
            }
        }
        return cnt;
    }
}
