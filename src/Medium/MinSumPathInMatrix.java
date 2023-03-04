package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinSumPathInMatrix {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int n,m;
        String []str=br.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> list=new ArrayList<>();
            str=br.readLine().split(" ");
            for(int j=0;j<m;j++){
                list.add(Integer.parseInt(str[j]));
            }
            A.add(list);
        }
        MinSumPathInMatrix obj=new MinSumPathInMatrix();
        System.out.println(obj.minPathSum(A));
    }
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
        int []temp=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i-1)>=0 && (j-1)>=0){
                    temp[j]=A.get(i).get(j)+Math.min(temp[j-1], temp[j]);
                }else if((i-1)>=0){
                    temp[j]=A.get(i).get(j)+temp[j];
                }else if((j-1)>=0){
                    temp[j]=A.get(i).get(j)+temp[j-1];
                }else{
                    temp[j]=A.get(i).get(j);
                }
            }
        }
        return temp[m-1];
    }
}
