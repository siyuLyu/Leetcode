import java.util.*;
public class lc128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        DSU uf = new DSU(nums.length);
        
        for (int i = 0; i < nums.length; i++) {
            //check if nums[i] exist in maps, remove duplicate
            if (map.containsKey(nums[i])) continue;
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            //union positions
            if (map.containsKey(nums[i] -1)) {
                uf.union(map.get(nums[i] - 1), i);
            }
              if (map.containsKey(nums[i] +1)) {
                uf.union(map.get(nums[i] + 1), i);
            }
        }
        return uf.getLongest();
    }
    
}
class DSU{
        int[] parent;
        int[] size;
        public DSU(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int c) {
            System.out.println(c);
            if (parent[c] == c) {
                return c;
            }
            parent[c] = find(parent[c]);
            return parent[c];
        }
        
        public void union(int src, int dest) {
            int x = find(src);
            int y = find(dest);
            
            if (x == y) return;
            
            if (size[x] > size[y]) {
                parent[y] = x;
                size[x] += size[y];
            } else if(size[x] <= size[y]){
                 parent[x] = y;
                 size[y] += size[x];
            } 
            
        }
        
        public int getLongest() {
             System.out.println(Arrays.toString(size));
            int max = 0;
            for (int s: size) {
                max = Math.max(max, s);
            }
            return max;
    }
    
}
