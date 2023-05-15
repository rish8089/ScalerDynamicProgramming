package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MaxSumWithoutAdjacentElements2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        MaxSumWithoutAdjacentElements2 obj=new MaxSumWithoutAdjacentElements2();
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(int i=0;i<2;i++){
            String []str=br.readLine().split(" ");
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<str.length;j++) {
                list.add(Integer.parseInt(str[j]));
            }
            A.add(list);
        }
        System.out.println(obj.adjacent(A));
    }
    public int adjacent(ArrayList<ArrayList<Integer>> A){
        int a=0;
        int b=0;
        int c=0;
        int m=A.get(0).size();
        for(int i=0;i<m;i++){
            c=Math.max(b,a+Math.max(A.get(0).get(i),A.get(1).get(i)));
            a=b;
            b=c;
        }
        return c;
    }
}
