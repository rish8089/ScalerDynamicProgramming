package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatingSubsequence2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        RepeatingSubsequence2 obj=new RepeatingSubsequence2();
        System.out.println(obj.anytwo(br.readLine()));
    }
    public int anytwo(String A) {
        int [][]dp=new int[2][A.length()];
        for(int i=0;i<A.length();i++){
            for(int j=0;j<A.length();j++){
                if(i!=j && A.charAt(i)==A.charAt(j)){
                    dp[1][j]=1+(j-1>=0?dp[0][j-1]:0);
                }else
                    dp[1][j]=Math.max(dp[0][j],j-1>=0?dp[1][j-1]:0);
                if(dp[1][j]>=2)
                    return 1;
            }
            for(int j=0;j<A.length();j++)
                dp[0][j]=dp[1][j];
        }
        return 0;
    }
}
