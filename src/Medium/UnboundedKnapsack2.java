package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UnboundedKnapsack2 {
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
        UnboundedKnapsack2 obj=new UnboundedKnapsack2();
        System.out.println(obj.solve(Integer.parseInt(br.readLine()),A,B));
    }
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C){
        int []dp=new int[A+1];
        int n=B.size();
        for(int i=1;i<=A;i++){
            for(int j=0;j<n;j++){
                if(C.get(j)<=i)
                    dp[i]=Math.max(dp[i],B.get(j)+dp[i-C.get(j)]);
            }
        }
        return dp[A];
    }
}
