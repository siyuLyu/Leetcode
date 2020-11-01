public class lc236LowestCommonAncestorofaBinaryTree {
    //Method 1 recursive
    //    3
    //  5   1
    //6  2 0  8
    //  7  4
    // p = 5 q=1
    // base case root == p or q or null return root
    //check left until found p or q or null, return what ever been found
    //check right until found p or q or null, return what ever been found
    // case1 left != null && right != null which meand lca is root
    // case 2 left != null && right == null ----> lca is left
    // case 3 right != null && left == null ----> lca is right
    //Time O(n)
    //Space O(n)
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q); 
        TreeNode right = lowestCommonAncestor(root.right, p, q); 
        
        if(left != null && right != null) {
            return root;
        } else if (right == null) {
            return left;
        } else {
            return right;
        }
        
    }
}
