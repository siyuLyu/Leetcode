public class lc344ReverseString {
    // Time O(n) n is the length of array, n/2 swaps
    //Space O(n) call stack
    public static void reverseString(char[] s) {
        helper(s, 0, s.length-1);
        
    }
    
    public static void helper(char[] s, int l, int r) {
        if (l < 0 || r > s.length -1 || l >= r) return;
        
        char tmp = s[l];
        s[l] = s[r];
        s[r] = tmp;
        
        helper(s, l+1, r-1);
        
        
    }
    public static void main(String[] argv) {
       char[] s = {'h','e','l','l','o'};
      reverseString(s);
    }
}
