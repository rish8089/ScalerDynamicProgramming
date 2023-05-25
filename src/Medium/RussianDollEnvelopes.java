package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RussianDollEnvelopes {
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
    public int solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<A.size();i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.size();j++){
                if(A.get(j).get(0)<A.get(i).get(0) && A.get(j).get(1)<A.get(i).get(1))
                    adj.get(i).add(j);
            }
        }
        int []res=new int[A.size()];
        int ans=0;
        for(int i=0;i<A.size();i++){
            if(res[i]==0)
                rec(res,adj,A,i);
            ans=Math.max(ans,res[i]);
        }
        return ans;
    }
    private void rec(int []res, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> A, int u){
        for(int i=0;i<adj.get(u).size();i++){
            int v=adj.get(u).get(i);
            if(res[v]==0)
                rec(res,adj,A,v);
            res[u]=Math.max(res[u],res[v]+1);
        }
        if(res[u]==0)
            res[u]=1;
    }
}
