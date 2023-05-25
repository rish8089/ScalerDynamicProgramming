package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ZeroOneKnapsackII {
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
        ZeroOneKnapsackII obj=new ZeroOneKnapsackII();
        System.out.println(obj.solve(A,B,Integer.parseInt(br.readLine())));
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int maxVal=0;
        int n=A.size();
        for(int i=0;i<n;i++)
            maxVal+=A.get(i);
        int [][]dp=new int[2][maxVal+1];
        Arrays.fill(dp[0],-1);
        dp[0][0]=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<=maxVal;j++){
                if(A.get(i)<=j) {
                    int val1 = dp[0][j];
                    int val2 = dp[0][j - A.get(i)];
                    if (val1 == -1 && val2 == -1)
                        dp[1][j] = -1;
                    else if (val1 == -1)
                        dp[1][j] = B.get(i) + val2;
                    else if (val2 == -1)
                        dp[1][j] = val1;
                    else
                        dp[1][j] = Math.min(val1, B.get(i) + val2);
                }else{
                    dp[1][j]=dp[0][j];
                }
            }
            for(int j=1;j<=maxVal;j++)
                dp[0][j]=dp[1][j];
        }
        int ans=0;
        for(int i=1;i<=maxVal;i++){
            if(dp[0][i]!=-1 && dp[0][i]<=C)
                ans=Math.max(ans,i);
        }
        return ans;
    }
}
