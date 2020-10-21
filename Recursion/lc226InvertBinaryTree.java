public class lc226InvertBinaryTree {
    //Time O(n) traverse all node
    //Space O(n) call satck
    public TreeNode invertTree(TreeNode root) {
        //base case
        if (root == null) return root;
        
        //invert right child's children and left child's children
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        
        //invert root
        root.right = left;
        root.left = right;
        
        return root;
        
    }
}
