package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CoinSumInfinite2 {
    private int MOD=(int)1e6+7;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        CoinSumInfinite2 obj=new CoinSumInfinite2();
        System.out.println(obj.coinchange2(A,Integer.parseInt(br.readLine())));
    }
    public int coinchange2(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n=A.size();
        int []dp=new int[B+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=1;j<=B;j++){
                if(A.get(i)<=j)
                    dp[j]=(dp[j]+dp[j-A.get(i)])%MOD;
            }
        }
        return dp[B];
    }
}
