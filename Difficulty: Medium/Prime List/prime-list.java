//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    Node primeList(Node head) {
        // code here
         Node res = new Node(0);
        Node temp = res;
        
        while(head != null){
            int leftPrime = getLeftPrime(head.val);
            int rightPrime = getRightPrime(head.val  + 1);
            //System.out.println(leftPrime +" " + rightPrime);
            if((Math.abs(head.val - leftPrime) <= Math.abs(head.val - rightPrime))){
                temp.next = new Node(leftPrime);
                temp = temp.next;
            }else{
                temp.next = new Node(rightPrime);
                temp = temp.next;
            }
            head = head.next;
        }
        return res.next;
        
        
    }
    int getLeftPrime(int n){
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(prime[i]){
                for(int j=i*i; j<=n; j += i){
                    prime[j] = false;
                }
            }
        }
        for(int i=n; i>=0; i--){
            if(prime[i])return i;
        }
        return -1;
    }
    int getRightPrime(int n){
        
        while(true){
            if(isPrime(n)) return n;
            n++;
        }
    }
    private boolean isPrime(int n ){
        for(int i=2; i<=Math.sqrt(n); i++){
                if(n%i == 0)return false;
            }
            return true;
    }
}