package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RussianEnvelopesLIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(int i=0;i<n;i++){
            String []hw=br.readLine().split(" ");
            A.add(new ArrayList<>(List.of(Integer.parseInt(hw[0]),Integer.parseInt(hw[1]))));
        }
        RussianDollEnvelopes obj=new RussianDollEnvelopes();
        System.out.println(obj.solve(A));
    }
    public int solve(ArrayList<ArrayList<Integer>> A){
        Collections.sort(A, (l1,l2)->Integer.compare(l1.get(0),l2.get(0)));
        int []dp=new int[A.size()];
        int ans=0;
        for(int i=0;i<A.size();i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(A.get(j).get(0)<A.get(i).get(0) && A.get(j).get(1)<A.get(i).get(1)){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
