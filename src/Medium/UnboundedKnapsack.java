package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UnboundedKnapsack {
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
        UnboundedKnapsack obj=new UnboundedKnapsack();
        System.out.println(obj.solve(Integer.parseInt(br.readLine()),A,B));
    }
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int n=B.size();
        int [][]dp=new int[2][A+1];
        for(int i=0;i<n;i++){
            int w=C.get(i);
            ArrayList<PriorityQueue<PQNode>> list=new ArrayList<>();
            Map<Integer,Integer> mp=new HashMap<>();
            for(int j=0;j<=Math.min(w-1,A);j++){
                PriorityQueue<PQNode> pq=new PriorityQueue<>((PQNode nd1,PQNode nd2)->{
                    return Integer.compare(nd2.v,nd1.v);
                });
                list.add(pq);
                int maxVal=(A-j)/w*w+j;
                for(int k=j;k<=maxVal;k+=w)
                    pq.add(new PQNode(k,dp[0][k]+((maxVal-k)/w)*B.get(i)));
                while(!pq.isEmpty()){
                    PQNode pqnd=pq.poll();
                    mp.put(pqnd.w, pq.size()+1);
                }
            }
            for(int j=0;j<=A;j++){
                int idx=j%w;
                PriorityQueue<PQNode> pq=list.get(idx);
                pq.add(new PQNode(j,mp.get(j)));
                PQNode top=pq.peek();
                dp[1][j]=dp[0][top.w]+(j-top.w)/w*B.get(i);
            }
            for(int j=1;j<=A;j++)
                dp[0][j]=dp[1][j];
        }
        return dp[0][A];
    }
    class PQNode{
        int w;
        int v;
        PQNode(int w, int v){
            this.w=w;
            this.v=v;
        }
    }

}
