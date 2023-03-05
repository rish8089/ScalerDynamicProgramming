package Hard;

import Medium.LongestCommonSubsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterleavingStrings {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String s1=br.readLine();
        String s2=br.readLine();
        String s3=br.readLine();
        InterleavingStrings obj=new InterleavingStrings();
        System.out.println(obj.isInterleave(s1,s2,s3));
    }
    public int isInterleave(String A, String B, String C) {
        int n=A.length();
        int m=B.length();
        if(n+m!=C.length())
            return 0;
        boolean []temp=new boolean[m+1];
        //here indexing will start with 1
        //i=0 will indicate that we just need to match characters of string B with C
        //j=0 will indicate that we just need to match characters of string A with C
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 && j==0)
                    temp[j]=true;
                else if(i==0)
                    temp[j]=temp[j-1] && B.charAt(j-1)==C.charAt(j-1);
                else if(j==0)
                    temp[j]=temp[j] && A.charAt(i-1)==C.charAt(i-1);
                else{
                    char c1=A.charAt(i-1);
                    char c2=B.charAt(j-1);
                    char c3=C.charAt(i+j-1);
                    if(c1==c2){
                        if(c1==c3)
                            temp[j]=temp[j] || temp[j-1];
                        else
                            temp[j]=false;
                    }else{
                        if(c1==c3){
                            temp[j]=temp[j];
                        }else if(c2==c3){
                            temp[j]=temp[j-1];
                        }else{
                            temp[j]=false;
                        }
                    }
                }
            }
        }
        return temp[m]?1:0;
    }
}
