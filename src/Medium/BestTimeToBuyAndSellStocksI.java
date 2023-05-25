package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStocksI {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        List<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        BestTimeToBuyAndSellStocksI obj=new BestTimeToBuyAndSellStocksI();
        System.out.println(obj.maxProfit(A));
    }
    public int maxProfit(final List<Integer> A) {
        int maxProfit=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<A.size();i++){
            maxProfit=Math.max(maxProfit,A.get(i)-min);
            min=Math.min(min,A.get(i));
        }
        return maxProfit;
    }
}
