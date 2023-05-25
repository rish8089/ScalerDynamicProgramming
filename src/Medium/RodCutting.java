package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class RodCutting {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        ArrayList<Integer> B=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            B.add(Integer.parseInt(str[i]));
        RodCutting obj=new RodCutting();
        System.out.println(obj.rodCut(Integer.parseInt(br.readLine()),B));
    }
    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
        ArrayList<Integer> C=new ArrayList<>();
        C.add(0);
        C.addAll(B);
        C.add(A);
        int n=C.size();
        Node [][]dp=new Node[n][n];
        for(int j=0;j<2;j++){
            for(int i=0;i<n-j;i++)
                dp[i][i+j]=new Node(0,-1);
        }
        for(int j=2;j<n;j++){
            for(int i=0;i<n-j;i++){
                int length=C.get(i+j)-C.get(i);
                dp[i][i+j]=new Node(-1,-1);
                //solving for range [i,i+j]
                for(int k=i+1;k<i+j;k++){
                    if(dp[i][i+j].cost==-1 || dp[i][i+j].cost>length+dp[i][k].cost+dp[k][i+j].cost) {
                        dp[i][i + j].cost = length + dp[i][k].cost + dp[k][i + j].cost;
                        dp[i][i+j].pos=k;
                    }
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        generateAns(dp,0,n-1,ans,C);
        return ans;

    }

    private void generateAns(Node [][]dp, int l, int r, ArrayList<Integer> ans, ArrayList<Integer> C){
        if(dp[l][r].pos==-1)
            return;
        ans.add(C.get(dp[l][r].pos));
        generateAns(dp,l,dp[l][r].pos,ans,C);
        generateAns(dp,dp[l][r].pos,r,ans,C);
    }
    class Node{
        long cost;
        int pos;
        Node(long cost, int pos){
            this.cost=cost;
            this.pos=pos;
        }
    }
}
