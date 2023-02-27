package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumber {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int A=Integer.parseInt(br.readLine());
        if (A <= 1)
            System.out.println(A);
        int a = 0;
        int b = 1;
        int i = 2;
        int c = -1;
        while (i <= A) {
            c = a + b;
            a = b;
            b = c;
            i++;
        }
        System.out.println(c);
    }
}
