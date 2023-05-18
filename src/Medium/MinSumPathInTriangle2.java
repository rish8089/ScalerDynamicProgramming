package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinSumPathInTriangle2{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> list=new ArrayList<>();
            String []str=br.readLine().split(" ");
            for(int j=0;j<=i;j++){
                list.add(Integer.parseInt(str[j]));
            }
            A.add(list);
        }
        MinSumPathInTriangle2 obj=new MinSumPathInTriangle2();
        System.out.println(obj.minimumTotal(A));
    }
    public int minimumTotal(ArrayList<ArrayList<Integer>> a){
        int n=a.size();
        int [][]dp=new int[2][n];
        dp[0][0]=a.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                dp[1][j]=a.get(i).get(j)+Math.min(i!=j?dp[0][j]:Integer.MAX_VALUE,j-1>=0?dp[0][j-1]:Integer.MAX_VALUE);
            }
            for(int j=0;j<=i;j++)
                dp[0][j]=dp[1][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
            ans=Math.min(ans,dp[0][j]);
        return ans;
    }
}
