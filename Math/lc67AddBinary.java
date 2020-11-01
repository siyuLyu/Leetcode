public class lc67AddBinary {
    //Method 1:
    //Time: O(max(N,M))
    //Space: O(max(N,M)) 
    
    public String addBinary(String a, String b) {
        if (a == null && b == null) return "";
        int m = a.length();
        int n = b.length();
        if (n > m) {
        // need to place a return , if a.length < b.length swap a and b
           return addBinary(b, a);
        }
        
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        int aIndex = m-1;
        int bIndex = n-1;
        
        System.out.println(a + " " + b);
        
        while (bIndex >= 0) {
            if(a.charAt(aIndex--) == '1') {
                carry++;
            }
            if(b.charAt(bIndex--) == '1') {
                carry++;
            }
            
            if(carry % 2 == 0) {
                sb.append(0);
            }else {
                sb.append(1);
            }
            
            carry /= 2;
            
        }
        
        while (aIndex >= 0) {
            if(a.charAt(aIndex--) == '1') {
                carry++;
            }
            if(carry % 2 == 0) {
                sb.append(0);
            }else {
                sb.append(1);
            }
            
            carry /= 2;
        }
        
        if (carry == 1) {
            sb.append(1);
        }
        
        return sb.reverse().toString();
      
        
    }
}
