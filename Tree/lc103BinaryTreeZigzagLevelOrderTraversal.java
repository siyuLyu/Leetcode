import java.util.*;
//Method1 dfs:
//Time O(n): n is the amount of node
//Space O(h): h is the height of tree O(log2^n)
         //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7 
         //      
        //res:[[3], [20,9] [15 7]]
public class lc103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       
                List<List<Integer>> res = new ArrayList<>();
                if (root == null) return res;
                helper(root, 1,res);
                return res;
                
                
                
            }
            
            private void helper(TreeNode root, int level, List<List<Integer>> res) {
                    if(root == null) return;
                   
                    if (res.size() < level) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(root.val);
                        res.add(curr);
                    }else {
                        List<Integer> curr = res.get(level-1);
                        if (level %2 == 0) {
                            curr.add(0, root.val);
                        } else {
                            curr.add(root.val);
                        }
                        
                    }
                    
                   
                    helper(root.left, level+1, res);
                    helper(root.right, level+1, res);
                    
                    return;
                }

                //Method2 two stacks
    //Time O(n)
    //Space O(n)
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        
        boolean flag = false;
        s1.add(root);
        
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            if (!flag){
                int size = s1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode tmp = s1.pop();
                    curr.add(tmp.val);
                    if(tmp.left != null) {
                        s2.push(tmp.left);
                    }
                    if(tmp.right != null) {
                        s2.push(tmp.right);
                    }
                }
                flag = true;
                
            } else {
                int size = s2.size();
                for (int i = 0; i < size; i++) {
                    TreeNode tmp = s2.pop();
                    curr.add(tmp.val);
                    if(tmp.right != null) {
                        s1.push(tmp.right);
                    }
                    if(tmp.left != null) {
                        s1.push(tmp.left);
                    }
                }
                flag = false;
                
            }
           
                
                 res.add(curr);
           
          
            
            
        }
        return res;
        
    }
                
    
}
