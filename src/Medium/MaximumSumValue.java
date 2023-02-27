package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MaximumSumValue {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int N=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<N;i++)
            list.add(Integer.parseInt(str[i]));
        int B=Integer.parseInt(br.readLine());
        int C=Integer.parseInt(br.readLine());
        int D=Integer.parseInt(br.readLine());
        MaximumSumValue obj=new MaximumSumValue();
        System.out.println(obj.solve(list,B,C,D));
    }
    public int solve(ArrayList<Integer> A, int B, int C, int D) {
        int N=A.size();
        int []firstMax=new int[N];
        for(int i=0;i<N;i++){
            if(i==0)
                firstMax[i]=A.get(i)*B;
            else
                firstMax[i]=Math.max(firstMax[i-1],A.get(i)*B);
        }
        int []thirdMax=new int[N];
        for(int i=N-1;i>=0;i--){
            if(i==N-1)
                thirdMax[i]=A.get(i)*D;
            else
                thirdMax[i]=Math.max(thirdMax[i+1],A.get(i)*D);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            if(ans<firstMax[i]+A.get(i)*C+thirdMax[i])
                ans=firstMax[i]+A.get(i)*C+thirdMax[i];
        }
        return ans;
    }
}
