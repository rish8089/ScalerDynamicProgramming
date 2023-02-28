package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaysToDecode {
    private int MOD=(int)1e9+7;
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String s=br.readLine();
        WaysToDecode obj=new WaysToDecode();
        System.out.println(obj.numDecodings(s));
    }
    public int numDecodings(String A) {
        int a=0;
        int b=1;
        for(int i=0;i<A.length();i++){
            char c=A.charAt(i);
            int noOfWays=0;
            if(c>='1' && c<='9'){
                noOfWays=b;
            }
            if((i-1)>=0) {
                int num = (A.charAt(i - 1) - '0') * 10 + (A.charAt(i) - '0');
                if (num >= 10 && num <= 26)
                    noOfWays = (noOfWays + a) % MOD;
            }
            a=b;
            b=noOfWays;
        }
        return b;
    }
}
