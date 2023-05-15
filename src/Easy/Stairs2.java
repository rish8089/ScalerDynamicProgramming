package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stairs2 {
    private int MOD=(int)1e9+7;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int A=Integer.parseInt(br.readLine());
        Stairs2 obj=new Stairs2();
        System.out.println(obj.climbStairs(A));
    }
    public int climbStairs(int A){
        if(A==1)
            return 1;
        int a=1;
        int b=1;
        int c=0;
        int i=2;
        while(i<=A){
            c=(a+b)%MOD;
            a=b;
            b=c;
            i++;
        }
        return c;
    }
}
