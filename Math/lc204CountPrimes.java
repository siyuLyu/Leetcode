import java.util.*;

class Solution {
    //Time O(n*log(log(n)))  =====> n/2 + n/3+ n/5+n/7+.......
    //Space O(n)
    public int countPrimes(int n) {
        if (n < 2) return 0;
        
        boolean[] prime = new boolean[n];
        // n-2 is because not count the first and last, for example, n is 10, not count 1 and 10
        int count = n-2;
        Arrays.fill(prime, true);
        
        // i*i to check not out of bound, because try to find i's multiple
        
        for (int i = 2; i*i < n; i++) {
            // for example: mark all 2's, then all 3's multiple
            // i*i = false
            // i*2i = false
            //and so on
            // j+= n is increment by i(try to find the multiple of i)
            for (int j = i*i; j < n; j += i) {
                prime[j] = false;
            }
        }
        
        for (boolean b: prime) {
            if (!b) {
                count--;
            }
        }
        
        return count;
        
    }
}