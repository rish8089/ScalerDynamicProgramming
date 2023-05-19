package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ZeroOneKnapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        ArrayList<Integer> B=new ArrayList<>();
        str=br.readLine().split(" ");
        for(int i=0;i<n;i++)
            B.add(Integer.parseInt(str[i]));
        ZeroOneKnapsack obj=new ZeroOneKnapsack();
        System.out.println(obj.solve(A,B,Integer.parseInt(br.readLine())));
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int [][]dp=new int[2][C+1];
        int n=A.size();
        for(int i=0;i<n;i++){
            for(int j=1;j<=C;j++){
                if(B.get(i)>j)
                    dp[1][j]=dp[0][j];
                else
                    dp[1][j]=Math.max(A.get(i)+dp[0][j-B.get(i)],dp[0][j]);
            }
            for(int j=1;j<=C;j++)
                dp[0][j]=dp[1][j];
        }
        return dp[0][C];
    }
}
