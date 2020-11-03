public class lc114FlattenBinaryTreetoLinkedList {
    //Time: O(n);
    //SpaceO(n) -> call stack
    /*
              1
             / \
            2   5
           /\    \
          3  4    6
          
         base case: root = null 
         
         
    1.flatten(6) 
         before prev: null
         output: 
         
              1
             / \
            2   5
           /\    \
          3  4    6
          after prev: 6
          
    2.flattern(5)
      before prev 6;
      output: 
         
              1
             / \
            2   5
           /\    \
          3  4    6
          
        after prev: 5
          
      3. flattern(4) 
          before prev: 5
          output: 
         
              1
             / \
            2   5
           /\    \
          3  4    6
              \
               5
                \
                 6
        after prev: 4
        
            
      4. flattern(3) 
          prev: 4 
          output: 
         
              1
             / \
            2   5
           /\    \
          3  4    6
          \   \
           4    5
            \    \
             5    6
              \
               6
        after prev 3
        
                
      5. flattern(2) 
          prev: 3 
          output: 
         
              1
             / \
            2   5
             \    \
              3    6
               \   
                4    
                 \    
                  5    
                   \
                    6
        after prev 2
        
        6. flattern(1) 
          prev: 3 
          output: 
         
          1
           \    
            2   
             \    
              3    
               \   
                4    
                 \    
                  5    
                   \
                    6
        after prev 1
    */
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        //base case
        if (root == null) return;
        
        // process inn the order right->left->cur
        //After flatten(root.right), we have processed the right branch of the current node, 
        //and the current prev is the head of root of the right branch
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
        
        
    }
}
