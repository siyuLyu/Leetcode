public class lc700SearchinaBinarySearchTree {
    //Time O(h) h is treeHeight
    //Space O(n) worst case call stack to each single node, O(logN) in the average case
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        
        if (root.val < val) {
            //need to return 
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
        
    }
    
}
