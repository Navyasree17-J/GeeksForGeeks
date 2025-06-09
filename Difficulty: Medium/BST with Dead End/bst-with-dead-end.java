/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    public boolean isDeadEnd(Node root) {
        return hasDeadEnd(root, 1, Integer.MAX_VALUE);
    }
    
    private boolean hasDeadEnd(Node node, int min, int max) {
        if (min == max) return true;
        
        if (node.left != null && node.right != null) {
            return hasDeadEnd(node.left, min, node.data - 1) || hasDeadEnd(node.right, node.data + 1, max);
        }
        
        if (node.left != null) {
            return hasDeadEnd(node.left, min, node.data - 1);
        }
        
        if (node.right != null) {
            return hasDeadEnd(node.right, node.data + 1, max);
        }
        
        return false;
    }
}