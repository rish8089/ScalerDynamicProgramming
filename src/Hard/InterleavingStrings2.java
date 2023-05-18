package Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterleavingStrings2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String A=br.readLine();
        String B=br.readLine();
        String C=br.readLine();
        InterleavingStrings2 obj=new InterleavingStrings2();
        System.out.println(obj.isInterleave(A,B,C));
    }
    public int isInterleave(String A, String B, String C) {
        int la=A.length();
        int lb=B.length();
        int lc=C.length();
        boolean [][][]dp=new boolean[lc+1][la+1][lb+1];
        //base cases
        for(int i=0;i<=lc;i++){
            for(int k=0;k<=lb;k++){
                if(i!=k)
                    dp[i][0][k]=false;
                else{
                    boolean res=true;
                    for(int l=1;l<=i;l++)
                        res=res && B.charAt(l-1)==C.charAt(l-1);
                    dp[i][0][k]=res;
                }
            }
        }
        for(int i=0;i<=lc;i++){
            for(int j=0;j<=la;j++){
                if(i!=j)
                    dp[i][j][0]=false;
                else{
                    boolean res=true;
                    for(int l=1;l<=i;l++)
                        res=res && A.charAt(l-1)==C.charAt(l-1);
                    dp[i][j][0]=res;
                }
            }
        }
        for(int i=1;i<=lc;i++){
            for(int j=1;j<=la;j++){
                for(int k=1;k<=lb;k++){
                    if(C.charAt(i-1)==A.charAt(j-1))
                        dp[i][j][k]=dp[i-1][j-1][k];
                    if(C.charAt(i-1)==B.charAt(k-1))
                        dp[i][j][k]=dp[i][j][k]|| dp[i-1][j][k-1];
                }
            }
        }
        return dp[lc][la][lb]?1:0;
    }
}
