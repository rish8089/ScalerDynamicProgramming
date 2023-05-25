package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BurstBalloons {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        BurstBalloons obj=new BurstBalloons();
        System.out.println(obj.solve(A));
    }
    public int solve(ArrayList<Integer> A) {
        ArrayList<Integer> B=new ArrayList<>();
        B.add(1);
        B.addAll(A);
        B.add(1);
        int n=B.size();
        int [][]dp=new int[n][n];
        for(int j=2;j<n;j++){
            for(int i=0;i<n-j;i++){
                //solving for range [i,i+j]
                for(int k=i+1;k<i+j;k++){
                    dp[i][i+j]=Math.max(dp[i][i+j],dp[i][k]+dp[k][i+j]+B.get(i)*B.get(k)*B.get(i+j));
                }
            }
        }
        return dp[0][n-1];
    }
}
