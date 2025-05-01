//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG {
    Stack<Integer> minStack = new Stack<>();
    public void push(int a, Stack<Integer> s) {
        // add code here.
        s.push(a);
        if(minStack.isEmpty() || a <= minStack.peek()){
            minStack.push(a);
        }
    }

    public int pop(Stack<Integer> s) {
        // add code here.
        if(s.isEmpty()) return -1;
        int popped = s.pop();
        if(!minStack.isEmpty() && popped == minStack.peek()){
            minStack.pop();
        }
        return popped;
    }

    public int min(Stack<Integer> s) {
        // add code here.
        if(minStack.isEmpty()) return -1;
        return minStack.peek();
    }

    public boolean isFull(Stack<Integer> s, int n) {
        // add code here.
        return s.size() == n;
    }

    public boolean isEmpty(Stack<Integer> s) {
        // add code here.
        return s.isEmpty();
    }
}