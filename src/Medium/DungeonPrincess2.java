package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DungeonPrincess2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        DungeonPrincess2 obj=new DungeonPrincess2();
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
        System.out.println(obj.calculateMinimumHP(A));
    }
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A){
        int u=1;
        int v=(int)1e5;
        int ans=-1;
        while(u<=v){
            int mid=(u+v)/2;
            if(isPossible(A,mid)){
                ans=mid;
                v=mid-1;
            }else
                u=mid+1;
        }
        return ans;
    }
    private boolean isPossible(ArrayList<ArrayList<Integer>> A, int health){
        int n=A.size();
        int m=A.get(0).size();
        int []dp=new int[m];
        for(int j=0;j<m;j++){
            dp[j]=(j-1>=0?dp[j-1]:health)+A.get(0).get(j);
            if(dp[j]<=0)
                break;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int val=Math.max(dp[j],j-1>=0?dp[j-1]:0);
                dp[j]=val<=0?0:A.get(i).get(j)+val;
            }
        }
        return dp[m-1]>0;
    }
}
