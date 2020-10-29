public class lc54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        //Time: O(mn) iterate it through one by one 
        //Space:O(mn) m*n elements
        
        
        //[ 1, 2, 3 ],
        //[ 4, 5, 6 ],
        //[ 7, 8, 9 ]
        
        //l->r
        //u->d
        //r->l
        //d->u
        
        //[1,2,3,6,9,8,7,4,5]
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0|| matrix[0] == null ||matrix[0].length == 0) return res;
        int l = 0; 
        int r = matrix[0].length -1;
        int u = 0;
        int d = matrix.length -1;
        //** if the length of res equals to the total elemnet, break and return res;
        int sum = matrix.length*matrix[0].length;
        
      
        
        while (l < matrix[0].length && r >= 0 && u < matrix.length  && d >= 0 ) {
            // add elements from left to right
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            u++;
            //add element from up to down;
            if (res.size() >= sum) break;
            
            for (int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            r--;
            // add elements from right to left
            if (res.size() >= sum) break;
            
            for (int i = r; i >= l; i--) {
                res.add(matrix[d][i]);
            }
            d--;
            if (res.size() >= sum) break;
            
            //add elemet from down to up
            for (int i = d; i >= u; i--) {
                res.add(matrix[i][l]);
            }
            l++;
            if (res.size() >= sum) break;
        }
        
        return res;
    }
    
}
