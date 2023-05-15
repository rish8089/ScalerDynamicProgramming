package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumber2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int A=Integer.parseInt(br.readLine());
        if(A==0 || A==1)
            System.out.println(A);
        else{
            int a=0;
            int b=1;
            int c=0;
            int i=2;
            while(i<=A){
                c=a+b;
                a=b;
                b=c;
                i++;
            }
            System.out.println(c);
        }
    }
}
