package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegularExpressionII {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String A=br.readLine();
        String B=br.readLine();
        RegularExpressionII obj=new RegularExpressionII();
        System.out.println(obj.isMatch(A,B));
    }

    public int isMatch(final String A, final String B) {
        //precomputation to reduce computation time
        int[][] precompute = new int[26][A.length()];
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            for (int j = A.length() - 1; j >= 0; j--) {
                if (A.charAt(j) == ch) {
                    int k = j;
                    while (j - 1 >= 0 && A.charAt(j - 1) == ch)
                        j--;
                    while (k >= j) {
                        precompute[i][k] = j - 1;
                        k--;
                    }
                } else
                    precompute[i][j] = j;
            }
        }

        boolean[][] dp = new boolean[2][A.length()];
        int[] sum = new int[A.length()];
        boolean allWildcards = true;
        for (int i = 0; i < B.length(); i++) {
            for (int j = 0; j < A.length(); j++) {
                if (i + 1 < B.length() && B.charAt(i + 1) == '*') {
                    char ch = B.charAt(i);
                    int endPos;
                    if (ch == '*' || ch == '.')
                        endPos = -1;
                    else
                        endPos = precompute[ch - 'a'][j];
                    int matches = sum[j] - (endPos > 0 ? sum[endPos - 1] : 0);
                    dp[1][j] = matches > 0 || (endPos == -1 && allWildcards);
                } else if (B.charAt(i) == '.')
                    dp[1][j] = dp[0][j] || (j - 1 >= 0 ? dp[0][j - 1] : allWildcards);
                  else {
                    if (A.charAt(j) == B.charAt(i))
                        dp[1][j] = j - 1 >= 0 ? dp[0][j - 1] : allWildcards;
                    else
                        dp[1][j] = false;
                }
            }
            for (int j = 0; j < A.length(); j++) {
                dp[0][j] = dp[1][j];
                sum[j] = (dp[0][j] ? 1 : 0) + (j - 1 >= 0 ? sum[j - 1] : 0);
            }
            allWildcards = allWildcards && (B.charAt(i) == '.' || (i + 1 < B.length() && B.charAt(i + 1) == '*'));
            //incrementing i in case of (ch)*
            if (i + 1 < B.length() && B.charAt(i + 1) == '*')
                i++;
        }
        return dp[0][A.length() - 1] ? 1 : 0;
    }
}
