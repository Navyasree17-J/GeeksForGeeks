//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findMaximum(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMaximum(int[] arr) {
        // code here
         int ans=arr[0];
        int s=0;
        int e=arr.length-1;
        
        while(s<e){
            int mid=(s+e)>>1;
            
            if(arr[mid-1]<arr[mid]  && arr[mid+1]<arr[mid])return arr[mid];
            if(arr[mid-1]<arr[mid]){
               s=mid+1; 
            }else {
                e=mid-1;
            }
        }
        
        return arr[e];
    }
}