package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNumberOfSquares2{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        MinimumNumberOfSquares2 obj=new MinimumNumberOfSquares2();
        System.out.println(obj.countMinSquares(Integer.parseInt(br.readLine())));
    }
    public int countMinSquares(int A) {
        int []minCount=new int[A+1];
        for(int i=1;i<=A;i++){
            int sqrt=(int)Math.sqrt(i);
            int minVal=-1;
            for(int j=1;j<=sqrt;j++){
                if(minVal==-1 || minVal>1+minCount[i-j*j])
                    minVal=1+minCount[i-j*j];
            }
            minCount[i]=minVal;
        }
        return minCount[A];
    }
}
