package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MaxSumWithoutAdjacentElements {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        MaxSumWithoutAdjacentElements obj=new MaxSumWithoutAdjacentElements();
        int N=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> grid=new ArrayList<>();
        for(int i=0;i<2;i++){
            ArrayList<Integer> list=new ArrayList<>();
            String []str=br.readLine().split(" ");
            for(int j=0;j<N;j++) {
                list.add(Integer.parseInt(str[j]));
            }
            grid.add(list);
        }
        System.out.println(obj.adjacent(grid));
    }
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int a=0;
        int b=Math.max(A.get(0).get(0),A.get(1).get(0));
        int N=A.get(0).size();
        for(int i=1;i<N;i++){
            int c=Math.max(a+Math.max(A.get(0).get(i),A.get(1).get(i)),b);
            a=b;
            b=c;
        }
        return b;
    }
}
