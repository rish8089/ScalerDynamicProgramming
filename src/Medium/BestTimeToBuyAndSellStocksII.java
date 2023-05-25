package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStocksII {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        List<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        BestTimeToBuyAndSellStocksII obj=new BestTimeToBuyAndSellStocksII();
        System.out.println(obj.maxProfit(A));
    }
    public int maxProfit(final List<Integer> A) {
        int maxProfit=0;
        for(int i=0;i<A.size();i++){
            while(i+1<A.size() && A.get(i)>=A.get(i+1))
                i++;
            int j=i;//buy index
            while(i+1<A.size() && A.get(i)<=A.get(i+1))
                i++;
            maxProfit+=A.get(i)-A.get(j);
        }
        return maxProfit;
    }
}
