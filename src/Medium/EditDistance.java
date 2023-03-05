package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String s1=br.readLine();
        String s2=br.readLine();
        EditDistance ed=new EditDistance();
        System.out.println(ed.minDistance(s1,s2));
    }
    public int minDistance(String A, String B) {
        int n=A.length();
        int m=B.length();
        int []temp=new int[m];
        int []temp1=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A.charAt(i)==B.charAt(j)) {
                    if((i-1)>=0 && (j-1)>=0)
                        temp1[j] = temp[j - 1];
                    else if((i-1)>=0) //i deletions
                        temp1[j]=i;
                    else if((j-1)>=0) // j insertions
                        temp1[j]=j;
                }
                else{
                    if((i-1)>=0 && (j-1)>=0){
                        temp1[j]=1+Math.min(temp1[j-1],Math.min(temp[j],temp[j-1])); //updation,insertion and deletion
                    }else if((i-1)>=0){
                        temp1[j]=1+Math.min(i,temp[j]); //updation and deletion
                    }else if((j-1)>=0){
                        temp1[j]=1+Math.min(j,temp1[j-1]); //updation and insertion
                    }else
                        temp1[j]=1;
                }
            }
            for(int j=0;j<m;j++)
                temp[j]=temp1[j];
        }
        return temp[m-1];
    }
}
