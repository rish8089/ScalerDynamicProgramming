package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntersectingChordsInACircle {
    static int MOD=(int)1e9+7;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        IntersectingChordsInACircle obj=new IntersectingChordsInACircle();
        System.out.println(obj.chordCnt(Integer.parseInt(br.readLine())));
    }
    public int chordCnt(int A) {
        int []dp=new int[A+1];
        dp[0]=1;
        for(int i=1;i<=A;i++){
            for(int j=0;j<=i-1;j++){
                dp[i]=(int)((dp[i]+((long)dp[j]*dp[i-1-j])%MOD)%MOD);
            }
        }
        return dp[A];
    }
}
