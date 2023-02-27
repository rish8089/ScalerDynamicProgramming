package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNumberOfSquares {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int A=Integer.parseInt(br.readLine());
        MinimumNumberOfSquares obj=new MinimumNumberOfSquares();
        System.out.println(obj.countMinSquares(A));
    }
    public int countMinSquares(int A) {
        int []minCount=new int[A+1];
        for(int i=1;i<=A;i++){
            int j=1;
            int minVal=-1;
            while(j*j<=i){
                if(minVal == -1 || minVal > minCount[i-j*j]){
                    minVal = 1+minCount[i-j*j];
                }
                j++;
            }
            minCount[i]=minVal;
        }
        return minCount[A];
    }
}
