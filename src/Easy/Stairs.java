package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stairs {
    private int MOD = (int)1e9+7;
    public static void main(String[] args) throws IOException {
        Stairs obj=new Stairs();
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int A=Integer.parseInt(br.readLine());
        System.out.println(obj.climbStairs(A));
    }

    public int climbStairs(int A) {
        if (A <= 2)
            return A;
        int a = 1;
        int b = 2;
        int i = 3;
        int c = -1;
        while (i <= A) {
            c = (a + b) % MOD;
            a = b;
            b = c;
            i++;
        }
        return c;
    }
}
