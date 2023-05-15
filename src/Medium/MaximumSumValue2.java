package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MaximumSumValue2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            list.add(Integer.parseInt(str[i]));
        MaximumSumValue2 obj=new MaximumSumValue2();
        String []BCD=br.readLine().split(" ");
        int B=Integer.parseInt(BCD[0]);
        int C=Integer.parseInt(BCD[1]);
        int D=Integer.parseInt(BCD[2]);
        System.out.println(obj.solve(list,B,C,D));
    }
    public int solve(ArrayList<Integer> A, int B, int C, int D){
        int n=A.size();
        Node []lminMax=new Node[n];
        Node []rminMax=new Node[n];
        for(int i=0;i<n;i++){
            lminMax[i]=new Node();
            lminMax[i].max=i-1>=0?Math.max(lminMax[i-1].max,A.get(i)):A.get(i);
            lminMax[i].min=i-1>=0?Math.min(lminMax[i-1].min,A.get(i)):A.get(i);
        }
        for(int i=n-1;i>=0;i--){
            rminMax[i]=new Node();
            rminMax[i].max=i+1<n?Math.max(rminMax[i+1].max,A.get(i)):A.get(i);
            rminMax[i].min=i+1<n?Math.min(rminMax[i+1].min,A.get(i)):A.get(i);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,(B>=0?lminMax[i].max:lminMax[i].min)*B+A.get(i)*C+(D>=0?rminMax[i].max:rminMax[i].min)*D);
        }
        return ans;
    }
    class Node{
        int min;
        int max;
    }
}
