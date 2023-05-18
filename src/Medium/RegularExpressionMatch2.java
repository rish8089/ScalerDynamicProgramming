package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegularExpressionMatch2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String A=br.readLine();
        String B=br.readLine();
        RegularExpressionMatch2 obj=new RegularExpressionMatch2();
        System.out.println(obj.isMatch(A,B));
    }
    public int isMatch(final String A, final String B) {
        boolean[][] dp = new boolean[2][A.length()];
        boolean allAsterisk = true;
        for (int i = 0; i < B.length(); i++) {
            boolean match = false;
            for (int j = 0; j < A.length(); j++) {
                match = match || dp[0][j];
                if (B.charAt(i) == A.charAt(j) || B.charAt(i)=='?') {
                    dp[1][j] = j - 1 >= 0 ? dp[0][j - 1] : allAsterisk;
                } else {
                    if (B.charAt(i) == '*')
                        dp[1][j] = match || allAsterisk;
                    else
                        dp[1][j] = false;
                }
            }
            for(int j=0;j<A.length();j++)
                dp[0][j]=dp[1][j];
            allAsterisk = allAsterisk && B.charAt(i) == '*';
        }
        return dp[0][A.length() - 1] ? 1 : 0;
    }
}
