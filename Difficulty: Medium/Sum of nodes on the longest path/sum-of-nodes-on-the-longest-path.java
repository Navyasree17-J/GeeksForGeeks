/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    int maxSum = 0, maxDepth = -1;
    public int sumOfLongRootToLeafPath(Node root) {
        // code here
        dfs(root, 0, 0);
        return maxSum;
    }
    
    private void dfs(Node root, int sum, int depth){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            if(depth>maxDepth){
                maxDepth = depth;
                maxSum = sum + root.data;
            }else if(depth==maxDepth){
                maxSum = Math.max(sum+root.data, maxSum);
            }
            return;
        }
        dfs(root.left, sum + root.data, depth+1);
        dfs(root.right, sum + root.data, depth+1);
    }
}