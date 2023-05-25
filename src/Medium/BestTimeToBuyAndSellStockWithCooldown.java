package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        BestTimeToBuyAndSellStockWithCooldown obj=new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(obj.solve(A));
    }
    public int solve(ArrayList<Integer> A) {
        int maxSell=0;
        int maxSellPrev=0;
        int maxBuy=-A.get(0);
        for(int i=1;i<A.size();i++){
            //if bought
            maxBuy=Math.max(maxBuy,-A.get(i)+maxSellPrev);
            //if sold
            maxSellPrev=maxSell;
            maxSell=Math.max(maxSell,A.get(i)+maxBuy);
        }
        return maxSell;
    }
}
