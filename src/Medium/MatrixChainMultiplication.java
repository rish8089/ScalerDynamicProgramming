package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        MatrixChainMultiplication obj=new MatrixChainMultiplication();
        ArrayList<Integer> list=new ArrayList<>();
        String []str=br.readLine().split(" ");
        for(int i=0;i<str.length;i++)
            list.add(Integer.parseInt(str[i]));
        System.out.println(obj.solve(list));
    }
    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        int [][]dp=new int[n][n];
        for(int j=1;j<n;j++){
            for(int i=1;i<n-j;i++){
                //[i,i+j]
                int minMul=Integer.MAX_VALUE;
                for(int k=i;k<i+j;k++) {
                    //[i to k] | [k+1][i+j]
                    minMul = Math.min(minMul, dp[i][k] + dp[k + 1][i + j] + A.get(i-1) * A.get(k) * A.get(i+j));
                }
                dp[i][i+j]=minMul;
            }
        }
        return dp[1][n-1];
    }
}
