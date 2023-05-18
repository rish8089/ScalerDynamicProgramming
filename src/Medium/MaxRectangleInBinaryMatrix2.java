package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxRectangleInBinaryMatrix2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []nm=br.readLine().split(" ");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(int i=0;i<n;i++){
            String []str=br.readLine().split(" ");
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<m;j++){
                list.add(Integer.parseInt(str[j]));
            }
            A.add(list);
        }
        MaxRectangleInBinaryMatrix2 obj=new MaxRectangleInBinaryMatrix2();
        System.out.println(obj.maximalRectangle(A));
    }
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A){
        int n=A.size();
        int m=A.get(0).size();
        int []pos=new int[m];
        Arrays.fill(pos,-1);
        int ans=0;
        for(int i=0;i<n;i++){
            ArrayList<Integer> heights=new ArrayList<>();
            for(int j=0;j<m;j++){
                if(i>pos[j]){
                    int k=i;
                    while (k<n && A.get(k).get(j) == 1) {
                        k++;
                    }
                    pos[j]=k-1;
                }
                heights.add(pos[j]-i+1);
            }
            ans=Math.max(ans,maximalArea(heights));
        }
        return ans;
    }
    private int maximalArea(ArrayList<Integer> heights){
        int n=heights.size();
        int []leftMaxSpan=new int[n];
        int []rightMaxSpan=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && heights.get(s.peek())>heights.get(i)){
                int pos=s.pop();
                rightMaxSpan[pos]=i-pos;
            }
            s.add(i);
        }
        while(!s.isEmpty()){
            int pos=s.pop();
            rightMaxSpan[pos]=n-pos;
        }
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && heights.get(s.peek())>heights.get(i)){
                int pos=s.pop();
                leftMaxSpan[pos]=pos-i;
            }
            s.add(i);
        }
        while(!s.isEmpty()){
            int pos=s.pop();
            leftMaxSpan[pos]=pos+1;
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea,(leftMaxSpan[i]+rightMaxSpan[i]-1)*heights.get(i));
        }
        return maxArea;
    }
}
