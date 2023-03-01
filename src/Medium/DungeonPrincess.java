package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DungeonPrincess {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int N=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(int i=0;i<N;i++){
            ArrayList<Integer> list=new ArrayList<>();
            String []str=br.readLine().split(" ");
            for(int j=0;j<N;j++){
                list.add(Integer.parseInt(str[j]));
            }
            A.add(list);
        }
        DungeonPrincess obj=new DungeonPrincess();
        System.out.println(obj.calculateMinimumHP(A));
    }
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int u=1;
        int v=100000;
        int ans=-1;
        while(u<=v){
            int mid=(u+v)/2;
            if(anyPathExists(A,mid)){
                ans=mid;
                v=mid-1;
            }else{
                u=mid+1;
            }
        }
        return ans;
    }

    private boolean anyPathExists(ArrayList<ArrayList<Integer>> A, int initialHealth) {
        int n=A.size();
        int m=A.get(0).size();
        int []temp=new int[m];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if ((i - 1) >= 0 && (j - 1) >= 0) {
                    if (temp[j] > 0 && temp[j - 1] > 0) {
                        temp[j] = A.get(i).get(j) + Math.max(temp[j - 1], temp[j]);
                    } else if (temp[j] > 0) {
                        temp[j] = A.get(i).get(j) + temp[j];
                    } else if (temp[j - 1] > 0) {
                        temp[j] = A.get(i).get(j) + temp[j - 1];
                    }
                    //else otherwise temp[j]<=0
                } else if ((i - 1) >= 0) {
                    if (temp[j] > 0)
                        temp[j] = A.get(i).get(j) + temp[j];
                    //else otherwise temp[j]<=0
                } else if ((j - 1) >= 0) {
                    if (temp[j - 1] > 0)
                        temp[j] = A.get(i).get(j) + temp[j - 1];
                    else
                        temp[j] = 0;
                } else {
                    temp[j] = A.get(i).get(j) + initialHealth;
                }
            }
        }
        return temp[m-1]>0;
    }
}
