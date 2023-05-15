package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaysToDecode2 {
    private int MOD=(int)1e9+7;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        WaysToDecode2 obj=new WaysToDecode2();
        System.out.println(obj.numDecodings(br.readLine()));
    }
    public int numDecodings(String A){
        int c=A.charAt(0)!='0'?1:0;
        int a=1;
        int b=c;
        for(int i=1;i<A.length();i++){
            int num=(A.charAt(i-1)-'0')*10+(A.charAt(i)-'0');
            c=((A.charAt(i)!='0'?b:0)+(num>=10 && num<=26?a:0))%MOD;
            a=b;
            b=c;
        }
        return c;
    }
}
