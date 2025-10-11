/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
     int maxSum = Integer.MIN_VALUE;

     int findMaxSum(Node node) {
        recursion(node);
        return maxSum;
    }

     int recursion(Node node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, recursion(node.left));
        int right = Math.max(0, recursion(node.right));
        maxSum = Math.max(maxSum, left + right + node.data);
        return node.data + Math.max(left, right);
    }
}