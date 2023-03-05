package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatingSubsequence {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String s1=br.readLine();
        RepeatingSubsequence obj=new RepeatingSubsequence();
        System.out.println(obj.anytwo(s1));
    }

    public int anytwo(String A) {
        int n=A.length();
        int []temp=new int[n];
        int []temp1=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && A.charAt(i)==A.charAt(j)){
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
            for(int j=0;j<n;j++){
                temp[j]=temp1[j];
            }
        }
        return temp[n-1]>=2?1:0;
    }
}
