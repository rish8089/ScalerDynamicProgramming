package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class WordBreak {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        WordBreak obj=new WordBreak();
        ArrayList<String> B=new ArrayList<>();
        String []str=br.readLine().split(" ");
        B.addAll(Arrays.asList(str));
        System.out.println(obj.wordBreak(br.readLine(),B));
    }
    public int wordBreak(String A, ArrayList<String> B) {
        int n=A.length();
        HashSet<String> hs = new HashSet<>(B);
        boolean []dp=new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=i;j>=Math.max(i-19,0);j--){
                String word=A.substring(j,i+1);
                if(hs.contains(word)){
                    if(j==0 || dp[j-1]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n-1]?1:0;
    }
}
