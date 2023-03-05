package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String s1=br.readLine();
        String s2=br.readLine();
        LongestCommonSubsequence obj=new LongestCommonSubsequence();
        System.out.println(obj.solve(s1,s2));
    }
    public int solve(String A, String B) {
        int n=A.length();
        int m=B.length();
        int []temp=new int[m];
        int []temp1=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A.charAt(i)==B.charAt(j)){
                    if((j-1)>=0)
                        temp1[j]=temp[j-1]+1;
                    else
                        temp1[j]=1;
                }else{
                    if((i-1)>=0 && (j-1)>=0){
                        temp1[j]=Math.max(temp[j],temp1[j-1]);
                    }else if((i-1)>=0)
                        temp1[j]=temp[j];
                    else if((j-1)>=0)
                        temp1[j]=temp1[j-1];
                }
            }
            for(int j=0;j<m;j++){
                temp[j]=temp1[j];
            }
        }
        return temp[m-1];
    }
}
