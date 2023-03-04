package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class MaxRectangleInBinaryMatrix {
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
        MaxRectangleInBinaryMatrix obj=new MaxRectangleInBinaryMatrix();
        System.out.println(obj.maximalRectangle(A));
    }
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
        int []temp=new int[m];
        int maxArea=0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<m;j++) {
                if (i == n - 1)
                    temp[j] = A.get(i).get(j);
                else {
                    temp[j] = A.get(i).get(j) == 1 ? 1 + temp[j] : 0;
                }
            }
            for(int j=0;j<m;j++){
                if(A.get(i).get(j)==1){
                    int k=j;
                    while(j+1<m && A.get(i).get(j+1) == 1){
                        j++;
                    }
                    // all elements are 1's from k to j
                    int subArrMaxArea=calculateMaximumArea(temp,k,j);
                    if(maxArea<subArrMaxArea)
                        maxArea=subArrMaxArea;
                }
            }
        }
        return maxArea;
    }
    private int calculateMaximumArea(int []temp, int i, int j) {
        Stack<Integer> s= new Stack<>();
        int []right=new int[j-i+1];
        int []left=new int[j-i+1];
        for(int k=i;k<=j;k++){
            while(!s.isEmpty() && temp[k]<temp[s.peek()]){
                right[s.peek()-i] = k-s.peek()-1;
                s.pop();
            }
            s.add(k);
        }
        while(!s.isEmpty()){
            right[s.peek()-i] = j-s.peek();
            s.pop();
        }
        for(int k=j;k>=i;k--){
            while(!s.isEmpty() && temp[k]<temp[s.peek()]){
                left[s.peek()-i] = s.peek()-k-1;
                s.pop();
            }
            s.add(k);
        }
        while(!s.isEmpty()){
            left[s.peek()-i] = s.peek()-i;
            s.pop();
        }
        int maxArea=0;
        for(int k=i;k<=j;k++){
            if(maxArea<(left[k-i]+right[k-i]+1)*temp[k]){
                maxArea=(left[k-i]+right[k-i]+1)*temp[k];
            }
        }
        return maxArea;
    }
}
