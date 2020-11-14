// Time Complexity: O(n^2)
// Space O(n);
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] e: edges) {
            
            int r1 = find(parent, e[0]);
            int r2 = find(parent, e[1]);
            
            if (r1 != r2) {
                parent[r1] = r2;
            } else {
                // if two vertices happen to be in the same set
            // then there's a cycle
                return false;
            }     
        }
        

        // valid tree must have n-1 edges
        
         return edges.length == n - 1;
        
    }
    
    private int find(int[] parent, int c) {
        if (parent[c] == c) {
            return parent[c];
        }
        parent[c] = find(parent, parent[c]);
        return parent[c];
    }
    

}