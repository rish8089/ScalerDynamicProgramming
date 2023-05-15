package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MaxProductSubarray2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            list.add(Integer.parseInt(str[i]));
        MaxProductSubarray2 obj=new MaxProductSubarray2();
        System.out.println(obj.maxProduct(list));
    }
    public int maxProduct(final List<Integer> A){
        int maxProduct=Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++){
            if(A.get(i)!=0){
                int j=i;
                while(i+1<A.size() && A.get(i+1)!=0)
                    i++;
                //now we can traverse elements from j to i as all are non-zero
                int maxp=Integer.MIN_VALUE;//max positive
                int maxn=Integer.MIN_VALUE;//max negative
                int currProduct=1;
                for(int k=j;k<=i;k++){
                    currProduct*=A.get(k);
                    if(currProduct>0)
                        maxProduct=Math.max(maxProduct,currProduct);
                    else{
                        maxProduct=Math.max(maxProduct,k!=j?maxn!=Integer.MIN_VALUE?currProduct/maxn:currProduct/maxp:currProduct);
                    }
                    if(currProduct>0){
                        maxp=Math.max(maxp,currProduct);
                    }else{
                        maxn=Math.max(maxn,currProduct);
                    }
                }
            }
        }
        if(maxProduct<0) {
            for (int i = 0; i < A.size(); i++) {
                if(A.get(i)==0)
                    return 0;
            }
        }
        return maxProduct;
    }
}
