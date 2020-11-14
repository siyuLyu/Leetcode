public class lc547FriendCircles {
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        int res = M.length;
        
        for (int i = 0; i < M.length; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                //identify weathe i&j are friends 
                if (M[i][j] == 1) {
                    //union
                    int root1 = find(parent, i);
                    int root2 = find(parent, j);
                    //if they are not same root, minus from res then change into same root
                    if (root1 != root2) {
                        res--;
                        parent[root1] = root2; 
                    }
                }
            }
        }
        
        return res;
        
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return parent[i];
        }
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}
