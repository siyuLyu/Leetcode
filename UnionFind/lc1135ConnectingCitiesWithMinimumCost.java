class Solution {
    //Time O(n^2);
    //Space O(n)
    public int minimumCost(int N, int[][] connections) {
        int res = 0;
        // keep the number of city
        int n = N;
        int[] parent = new int[N+1];
        
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(connections, (a,b)->(a[2]-b[2]));
        
        for (int[] c: connections) {
            int r1 = find(parent, c[0]);
            int r2 = find(parent, c[1]);
            
            if (r1!= r2) {
                res += c[2];
                parent[r1] = r2;
                n--;
                
            }
        }
        //n == 1 means all the city has been connected
        return n==1? res: -1;
        
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return parent[x];
        }
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
    
    
}