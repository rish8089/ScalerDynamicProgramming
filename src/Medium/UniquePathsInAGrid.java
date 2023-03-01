package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UniquePathsInAGrid {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int n,m;
        String []str=br.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(int i=0;i<n;i++){
            str=br.readLine().split(" ");
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<m;j++){
                list.add(Integer.parseInt(str[j]));
            }
            A.add(list);
        }
        UniquePathsInAGrid obj=new UniquePathsInAGrid();
        System.out.println(obj.uniquePathsWithObstacles(A));
    }
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
        int []temp=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A.get(i).get(j)==0){
                    if(j-1>=0 && i-1>=0){
                        temp[j]=temp[j-1]+temp[j];
                    }else if(i-1>=0)
                        temp[j]=temp[j];
                    else if(j-1>=0)
                        temp[j]=temp[j-1];
                    else
                        temp[j]=1;
                }else{
                    temp[j]=0;
                }
            }
        }
        return temp[m-1];
    }
}
