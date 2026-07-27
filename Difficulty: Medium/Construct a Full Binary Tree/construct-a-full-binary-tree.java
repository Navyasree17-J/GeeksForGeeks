/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    private int preIndex = 0;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        preIndex = 0;
        return buildTree(pre, preMirror, 0, preMirror.length - 1);
    }

    private Node buildTree(int[] pre, int[] preMirror, int l, int h) {
        if (l > h || preIndex >= pre.length) {
            return null;
        }

        // Create current root from pre[]
        Node root = new Node(pre[preIndex++]);

        // Base case: leaf node reached
        if (l == h || preIndex >= pre.length) {
            return root;
        }

        // Search for the next element of pre[] in preMirror[]
        int mirrorIndex = -1;
        for (int i = l; i <= h; i++) {
            if (preMirror[i] == pre[preIndex]) {
                mirrorIndex = i;
                break;
            }
        }

        // Recursively build left and right subtrees
        if (mirrorIndex != -1 && mirrorIndex <= h) {
            root.left = buildTree(pre, preMirror, mirrorIndex, h);
            root.right = buildTree(pre, preMirror, l + 1, mirrorIndex - 1);
        }

        return root;
    }
}