/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        // code here
        StringBuilder l1=new StringBuilder();
        helper(root1,l1);
        
        StringBuilder l2=new StringBuilder();
        helper(root2,l2);
        String s1=l1.toString();
        String s2=l2.toString();
        return s1.contains(s2);
        
        
        
        
    }
    private void helper(Node root,StringBuilder list){
        if(root==null) return;
        list.append(String.valueOf(root.data));
        helper(root.left,list);
        helper(root.right,list);
    }
}