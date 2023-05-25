package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PalindromePartitioningII {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        PalindromePartitioningII obj=new PalindromePartitioningII();
        System.out.println(obj.minCut(str));
    }
    public int minCut(String A) {
        int n=A.length();
        int []dp=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                //check if i to j is palindrome
                if(isPalindrome(A,j,i)){
                    int cuts=j-1>=0?1+dp[j-1]:0;
                    if(dp[i]==-1 || dp[i]>cuts)
                        dp[i]=cuts;
                }
            }
        }
        return dp[n-1];
    }
    private boolean isPalindrome(String A, int i, int j){
        while(i<=j){
            if(A.charAt(i)!=A.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
