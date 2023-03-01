package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinSumPathInTriangle {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int N=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(int i=0;i<N;i++){
            ArrayList<Integer> list=new ArrayList<>();
            String []str=br.readLine().split(" ");
            for(int j=0;j<=i;j++){
                list.add(Integer.parseInt(str[j]));
            }
            A.add(list);
        }
        MinSumPathInTriangle obj=new MinSumPathInTriangle();
        System.out.println(obj.minimumTotal(A));
    }
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int n=a.size();
        if(n==0)
            return 0;
        int []temp=new int[n];
        temp[0]=a.get(0).get(0);
        int []temp1=new int[n];
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(i==j){
                    temp1[j]=a.get(i).get(j)+temp[j-1];
                }else{
                    if(j-1>=0)
                        temp1[j]=a.get(i).get(j)+Math.min(temp[j-1],temp[j]);
                    else
                        temp1[j]=a.get(i).get(j)+temp[j];
                }
            }
            for(int j=0;j<=i;j++){
                temp[j]=temp1[j];
            }
        }
        int ans=temp[0];
        for(int i=1;i<n;i++){
            ans=Math.min(ans,temp[i]);
        }
        return ans;
    }
}
