class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //Time O(n)
        //Space: O(k)
        // key: Character value: frequent of Character
        Map<Character, Integer> map = new HashMap<>();
        int start = 0; 
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            map.put(ch, map.getOrDefault(ch, 0)+1);
            
            while (map.size() > k) {
                char left = s.charAt(start);
                map.put(left, map.get(left)-1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
               //start keep moving right 
                start++;
            }
            
            // int sum = 0;
            // for (char key: map.keySet()) {
            //     sum += map.get(key);
            // }
             count = Math.max(count, i-start+1);
           
        }
        return count;
       
        
    }
}