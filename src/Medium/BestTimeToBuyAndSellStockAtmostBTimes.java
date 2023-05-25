package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class BestTimeToBuyAndSellStockAtmostBTimes {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        BestTimeToBuyAndSellStockAtmostBTimes obj=new BestTimeToBuyAndSellStockAtmostBTimes();
        System.out.println(obj.solve(A,Integer.parseInt(br.readLine())));
    }
    public int solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            while(i+1<A.size() && A.get(i)>=A.get(i+1))
                i++;
            int j=i;//buy index
            while(i+1<A.size() && A.get(i)<=A.get(i+1))
                i++;
            list.add(-A.get(j));
            list.add(A.get(i));
        }
        int k=Math.min(2*B,list.size());
        int [][]dp=new int[list.size()][k+1];
        for(int i=0;i<list.size();i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        //chains of length 0 would have sum 0
        for(int i=0;i<list.size();i++)
            dp[i][0]=0;
        if(k>=1)
            dp[0][1]=list.get(0);
        for(int i=1;i<list.size();i++){
            for(int j=(i%2==0?1:2);j<=k;j+=2){
                if(i-2>=0)
                    dp[i][j]=dp[i-2][j];
                if(dp[i-1][j-1]!=Integer.MIN_VALUE)
                    dp[i][j]=Math.max(dp[i][j],list.get(i)+dp[i-1][j-1]);
            }
        }
        return list.size()%2==0?dp[list.size()-1][k]:list.size()-2>=0?dp[list.size()-2][k]:0;
    }
}
