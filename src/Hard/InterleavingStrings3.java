package Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterleavingStrings3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String A=br.readLine();
        String B=br.readLine();
        String C=br.readLine();
        InterleavingStrings3 obj=new InterleavingStrings3();
        System.out.println(obj.isInterleave(A,B,C));
    }
    public int isInterleave(String A, String B, String C) {
        int la=A.length();
        int lb=B.length();
        int lc=C.length();
        boolean [][][]dp=new boolean[2][la][lb];
        //base cases
        dp[0][0][0]=true;
        for(int i=0;i<lc;i++){
            for(int j=0;j<la;j++){
                for(int k=0;k<lb;k++){
                    if(C.charAt(i)==A.charAt(j))
                        dp[1][j][k]=j-1>=0?dp[0][j-1][k]:compare(C,B,i-1,k);
                    if(C.charAt(i)==B.charAt(k))
                        dp[1][j][k]=dp[1][j][k] || (k-1>=0?dp[0][j][k-1]:compare(C,A,i-1,j));
                }
            }
            for(int j=0;j<la;j++){
                for(int k=0;k<lb;k++)
                    dp[0][j][k]=dp[1][j][k];
            }
        }
        return dp[0][la-1][lb-1]?1:0;
    }
    private boolean compare(String A, String B, int i, int j){
        return A.substring(0,i+1).equals(B.substring(0,j+1));
    }
}
