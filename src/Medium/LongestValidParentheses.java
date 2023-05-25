package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestValidParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        LongestValidParentheses obj=new LongestValidParentheses();
        System.out.println(obj.longestValidParentheses(str));
    }
    public int longestValidParentheses(String A) {
        int n=A.length();
        int []dp=new int[n];
        int ans=0;
        for(int i=1;i<A.length();i++){
            int len=0;
            if(A.charAt(i)==')'){
                if(A.charAt(i-1)=='(')
                    len=2+(i-2>=0?dp[i-2]:0);
                else if(dp[i-1]!=0 && i-1-dp[i-1]>=0 && A.charAt(i-1-dp[i-1])=='(')
                    len=dp[i-1]+2+(i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0);
            }
            dp[i]=len;
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
