class Solution {
    //Time O(n^2)
    //Space O(n^2)
        
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            //don't forget base case, signle character is true;
            dp[i][i] = true;
            // the bond
            //  j i
            // "babad"
            for (int j = 0; j < i; j++) {
                // length is even or odd
                if (i - j < 2 || dp[j + 1][i-1]) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[j][i] = true;
                        //don't forget dp[j][i] = true;
                        if (i - j + 1 > max && dp[j][i]) {
                            max = i - j + 1;
                            start = j;
                            end = i;
                        }
                    }
                } 
            }
        }
        
        return s.substring(start, end+1);
        
    }
}