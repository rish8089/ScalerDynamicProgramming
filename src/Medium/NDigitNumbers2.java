package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NDigitNumbers2 {
    private int MOD=(int)1e9+7;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []AB=br.readLine().split(" ");
        int A=Integer.parseInt(AB[0]);
        int B=Integer.parseInt(AB[1]);
        NDigitNumbers2 obj=new NDigitNumbers2();
        System.out.println(obj.solve(A,B));
    }
    public int solve(int A, int B){
        int [][]dp=new int[2][B+1];
        for(int i=1;i<=Math.min(9,B);i++)
            dp[0][i]=1;
        for(int i=2;i<=A;i++){
            for(int j=1;j<=B;j++){
                int sum=0;
                for(int k=0;k<=Math.min(9,j-1);k++){
                    sum=(sum+dp[0][j-k])%MOD;
                }
                dp[1][j]=sum;
            }
            for(int j=1;j<=B;j++)
                dp[0][j]=dp[1][j];
        }
        return dp[0][B];
    }
}
