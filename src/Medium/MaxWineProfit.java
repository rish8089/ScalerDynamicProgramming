package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MaxWineProfit {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(Integer.parseInt(str[i]));
        MaxWineProfit obj=new MaxWineProfit();
        System.out.println(obj.solve(list));
    }
    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        int [][]dp=new int[2][n];
        for(int i=0;i<n;i++)
            dp[0][i]=n*A.get(i);
        for(int j=1;j<n;j++){
            for(int i=0;i<n-j;i++){
                //range is [i,i+j]
                dp[1][i]=Math.max((n-j)*A.get(i)+dp[0][i+1],(n-j)*A.get(i+j)+dp[0][i]);
            }
            for(int i=0;i<n;i++)
                dp[0][i]=dp[1][i];
        }
        return dp[0][0];
    }
}
