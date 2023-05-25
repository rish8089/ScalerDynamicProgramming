package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequenceNlogN {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        LongestIncreasingSubsequenceNlogN obj=new LongestIncreasingSubsequenceNlogN();
        System.out.println(obj.lis(A));
    }
    public int lis(final List<Integer> A){
        int n=A.size();
        int []len=new int[n+1];
        Arrays.fill(len,-1);
        int ans=0;
        for(int i=0;i<n;i++){
            int res=binarySearch(len,n,A.get(i),A);
            if(len[res+1]==-1 || A.get(len[res+1])>A.get(i))
                len[res+1]=i;
            ans=Math.max(ans,res+1);
        }
        return ans;
    }
    private int binarySearch(int []len, int n, int x, List<Integer> A){
        int u=1;
        int v=n;
        int ans=0;
        while(u<=v){
            int mid=(u+v)/2;
            if(len[mid]!=-1 && A.get(len[mid])<x) {
                ans = mid;
                u=mid+1;
            }else{
                v=mid-1;
            }
        }
        return ans;
    }
}
