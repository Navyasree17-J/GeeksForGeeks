//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String s = input[0];
            int k = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minValue(s,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int minValue(String S,int K) {
        int [] freq = new int[26];
        int ans = 0;
        for(int i =0;i<S.length(); i++){
            freq[S.charAt(i) -'a']++;
        }
        for(int i=0; i<K; i++){
            int p = 0;
            for(int j =0; j<26; j++){
                p=(freq[j] > freq[p]) ? j:p;
            }
            freq[p]--;
        }
        for(int i=0; i<26; i++){
            if(freq[i]>0){
                ans+=(int)Math.pow(freq[i],2);
            }
        }
        return ans;
    }
}