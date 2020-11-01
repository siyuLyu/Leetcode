// public class lc98ValidateBinarySearchTree {
//             //  10
//             // 5  15
//             //    6  20 
//     //root:5  null,10
//     //root: 15: null, 10
//     //root:6 15, null
//     //root:20 null 15
//     public static boolean isValidBST(TreeNode root) {
//         return helper(root, null, null);
        
//     }
    
//     public static boolean helper(TreeNode root, TreeNode left, TreeNode right) {
//         if (root == null) return true;
        
//         if(left != null && root.val <= left.val) return false; 
//         if(right != null && root.val >= right.val) return false; 
//         return helper(root.left, left, root) || helper(root.right,  root, right);
//     }
//     public static void main(String[] argv) {
//         // TreeNode t1 = new TreeNode(1);
//         // TreeNode t2 = new TreeNode(2);
//         // TreeNode t3 = new TreeNode(3);
//         // t2.left = t1;
//         // t2.right = t3;
//         // isValidBST(t1);

//         TreeNode t1 = new TreeNode(10);
//         TreeNode t2 = new TreeNode(5);
//         TreeNode t3 = new TreeNode(15);
//         TreeNode t4 = new TreeNode(6);
//         TreeNode t5 = new TreeNode(20);

//         t1.left = t2;
//         t1.right = t3;
//         t3.left = t4;
//         t4.right = t5;

//         isValidBST(t1);

//     }
// }
