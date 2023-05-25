package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoxStackingProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(int i=0;i<n;i++){
            String []hwl=br.readLine().split(" ");
            A.add(new ArrayList<>(Arrays.asList(Integer.parseInt(hwl[0]),Integer.parseInt(hwl[1]),Integer.parseInt(hwl[2]))));
        }
        BoxStackingProblem obj=new BoxStackingProblem();
        System.out.println(obj.solve(A));
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        for(int i=0;i<n;i++){
            int h=A.get(i).get(0);
            int w=A.get(i).get(1);
            int l=A.get(i).get(2);
            A.add(new ArrayList<>(Arrays.asList(h,l,w)));
            A.add(new ArrayList<>(Arrays.asList(w,h,l)));
            A.add(new ArrayList<>(Arrays.asList(w,l,h)));
            A.add(new ArrayList<>(Arrays.asList(l,h,w)));
            A.add(new ArrayList<>(Arrays.asList(l,w,h)));
        }
        Collections.sort(A,(l1,l2)->Integer.compare(l1.get(1),l2.get(1)));
        n=A.size();
        int []dp=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            dp[i]=A.get(i).get(0);
            for(int j=0;j<i;j++){
                if(A.get(j).get(1)<A.get(i).get(1) && A.get(j).get(2)<A.get(i).get(2)){
                    dp[i]=Math.max(dp[i],A.get(i).get(0)+dp[j]);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
