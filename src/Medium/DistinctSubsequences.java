package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistinctSubsequences {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String A=br.readLine();
        String B=br.readLine();
        DistinctSubsequences obj=new DistinctSubsequences();
        System.out.println(obj.numDistinct(A,B));
    }
    public int numDistinct(String A, String B) {
        int [][]dp=new int[2][B.length()];
        for(int i=0;i<A.length();i++){
            for(int j=0;j<B.length();j++){
                if(A.charAt(i)==B.charAt(j))
                    dp[1][j]=(j-1>=0?dp[0][j-1]:1)+dp[0][j];
                else
                    dp[1][j]=dp[0][j];
            }
            for(int j=0;j<B.length();j++)
                dp[0][j]=dp[1][j];
        }
        return dp[0][B.length()-1];
    }
}
