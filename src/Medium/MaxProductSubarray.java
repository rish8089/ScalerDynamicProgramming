package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MaxProductSubarray {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int N=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<N;i++)
            list.add(Integer.parseInt(str[i]));
        MaxProductSubarray obj=new MaxProductSubarray();
        System.out.println(obj.maxProduct(list));
    }
    public int maxProduct(final List<Integer> A) {
        int ans=-1;
        int lastMax=-1;
        int lastMin=-1;
        for(int i=0;i<A.size();i++){
            if(i==0){
                lastMax=A.get(i);
                lastMin=A.get(i);
                ans=A.get(i);
            }else{
                int newLastMax;
                if(A.get(i)>=0){
                    newLastMax=Math.max(lastMax*A.get(i),A.get(i));
                }else{
                    newLastMax=Math.max(lastMin*A.get(i),A.get(i));
                }

                int newLastMin;
                if(A.get(i)>=0){
                    newLastMin=Math.min(lastMin*A.get(i),A.get(i));
                }else{
                    newLastMin=Math.min(lastMax*A.get(i),A.get(i));
                }
                lastMax=newLastMax;
                lastMin=newLastMin;
                ans=Math.max(ans,lastMax);
            }
        }
        return ans;
    }
}
