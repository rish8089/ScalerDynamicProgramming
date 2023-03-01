package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NDigitNumbers {
    private int MOD=(int)1e9+7;
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int A=Integer.parseInt(br.readLine());
        int B=Integer.parseInt(br.readLine());
        NDigitNumbers obj=new NDigitNumbers();
        System.out.println(obj.solve(A,B));
    }
    public int solve(int A, int B) {
        //base case
        if(A==1){
            if(B<=9)
                return 1;
            else
                return 0;
        }
        int []temp=new int[B+1];
        for(int i=0;i<=9 && i<=B;i++){
            temp[i]=1;
        }
        int []temp1=new int[B+1];
        for(int i=2;i<=A;i++){
            int startDigit=(i==A)?1:0;
            for(int j=0;j<=B;j++){
                for(int k=startDigit;k<=9 && k<=j;k++){
                    //i digits number starting with k
                    if(j-k>=0){
                        temp1[j]=(temp1[j]+temp[j-k])%MOD;
                    }
                }
            }
            for(int j=0;j<=B;j++){
                temp[j]=temp1[j];
                temp1[j]=0;
            }
        }
        return temp[B];
    }
}
