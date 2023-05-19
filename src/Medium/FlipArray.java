package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        List<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        FlipArray obj=new FlipArray();
        System.out.println(obj.solve(A));
    }
    public int solve(final List<Integer> A) {
        int n=A.size();
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=A.get(i);
        int [][]dp=new int[2][2*sum+1];
        // 0 to sum -> sum + 1 elements
        // sum+1 to 2*sum -> negative elements
        Arrays.fill(dp[0],-1);
        dp[0][0]=0;
        for(int i=0;i<n;i++){
            for(int j=-sum;j<=sum;j++){
                //is j possible with first i+1 elements
                int idx = j < 0 ? sum + (-j) : j;
                int res1 = minFlips(dp[0], j - A.get(i), sum);
                int res2 = minFlips(dp[0], j + A.get(i), sum);
                if (res1 == -1 && res2 == -1)
                    dp[1][idx] = -1;
                else if (res1 != -1 && res2 == -1)
                    dp[1][idx] = res1;
                else if (res1 == -1 && res2 != -1)
                    dp[1][idx] = 1 + res2;
                else
                    dp[1][idx]=Math.min(res1,1+res2);
            }
            for(int j=0;j<=2*sum;j++)
                dp[0][j]=dp[1][j];
        }
        int ans=-1;
        int minResult=-1;
        for(int j=0;j<=sum;j++) {
            if(dp[0][j]!=-1){
                if(minResult==-1 || minResult>j) {
                    minResult = j;
                    ans=dp[0][j];
                }
            }
        }
        return ans;
    }
    private int minFlips(int []dp, int requiredSum, int totalSum){
        if(requiredSum>totalSum || requiredSum<-totalSum)
            return -1;
        if(requiredSum>=0)
            return dp[requiredSum];
        else
            return dp[totalSum+(-requiredSum)];
    }
}
