package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinSumPathInMatrix2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []nm=br.readLine().split(" ");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(int i=0;i<n;i++) {
            String[] str = br.readLine().split(" ");
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<m;j++)
                list.add(Integer.parseInt(str[j]));
            A.add(list);
        }
        MinSumPathInMatrix2 obj=new MinSumPathInMatrix2();
        System.out.println(obj.minPathSum(A));
    }
    public int minPathSum(ArrayList<ArrayList<Integer>> A){
        int n=A.size();
        int m=A.get(0).size();
        int []dp=new int[m];
        for(int i=0;i<m;i++){
            dp[i]=A.get(0).get(i)+(i-1>=0?dp[i-1]:0);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++)
                dp[j]=A.get(i).get(j)+Math.min(dp[j],j-1>=0?dp[j-1]:Integer.MAX_VALUE);
        }
        return dp[m-1];
    }
}
