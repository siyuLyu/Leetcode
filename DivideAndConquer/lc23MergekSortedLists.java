//Time : O(nlogk)
//Space O(1)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        int n = lists.length;
        
        while ( n > 1) {
         for (int i = 0; i < n / 2; i++) { 
              System.out.println(i + " "+(n-1-i));
             lists[i] = merge(lists[i], lists[n - 1 - i]);
         }
            n = ( n + 1 ) / 2;
            
        }
        
           
        return lists[0];
        
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;   
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        
        if (l1 != null) {
            head.next = l1;
        }
        
        if (l2 != null) {
            head.next = l2;
        }
        
        return dummy.next;
    }
}