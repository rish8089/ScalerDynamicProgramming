package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        LongestIncreasingSubsequence obj=new LongestIncreasingSubsequence();
        System.out.println(obj.lis(A));
    }
    public int lis(final List<Integer> A) {
        int ans=0;
        int []dp=new int[A.size()];
        for(int i=0;i<A.size();i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(A.get(j)<A.get(i))
                    dp[i]=Math.max(dp[i],1+dp[j]);
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
