package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        String s2=br.readLine();
        EditDistance2 obj=new EditDistance2();
        System.out.println(obj.minDistance(s1,s2));
    }
    public int minDistance(String A, String B){
        int [][]dp=new int[2][A.length()];
        for(int j=0;j<A.length();j++)
            dp[0][j]=j+1;
        for(int i=0;i<B.length();i++){
            for(int j=0;j<A.length();j++){
                if(B.charAt(i)==A.charAt(j)){
                    dp[1][j]=j-1>=0?dp[0][j-1]:i;
                }else {
                    int uc=1 + (j - 1 >= 0 ? dp[0][j - 1] : i);//updation cost
                    int idc=Math.min(1 + (j - 1 >= 0 ? dp[1][j - 1] : i + 1), 1 + dp[0][j]);//insertion deletion cost
                    dp[1][j] = Math.min(uc,idc);
                }
            }
            for(int j=0;j<A.length();j++)
                dp[0][j]=dp[1][j];
        }
        return dp[0][A.length()-1];
    }
}
