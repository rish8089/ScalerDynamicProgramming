package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UnboundedKnapsack4 {
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
        UnboundedKnapsack4 obj=new UnboundedKnapsack4();
        System.out.println(obj.solve(Integer.parseInt(br.readLine()),A,B));
    }
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int [][]dp=new int[2][A+1];
        int n=B.size();
        for(int i=0;i<n;i++){
            for(int j=1;j<=A;j++){
                if(C.get(i)>j)
                    dp[1][j]=dp[0][j];
                else
                    dp[1][j]=Math.max(B.get(i)+dp[1][j-C.get(i)],dp[0][j]);
            }
            for(int j=1;j<=A;j++)
                dp[0][j]=dp[1][j];
        }
        return dp[0][A];
    }
}
