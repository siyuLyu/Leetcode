public class lc148SortList {
    //Time: O(nlog(n))
    //Space O(log(n)) where nn is the number of nodes in linked list.
    //Since the problem is recursive, we need additional space to store the recursive call stack.
    public ListNode sortList(ListNode head) {
        //base case don't forget return head
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        
        while (fast != null && fast.next!= null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        return merge(sortList(head), sortList(slow));
    }
   

    
    public ListNode merge(ListNode first, ListNode second) {
        if (first == null) return second;
        if(second == null) return first;
        
        if (first.val < second.val) {
            ListNode next = first.next;
            first.next = merge(next, second);
            return first;
        } else {
            ListNode next = second.next;
            second.next = merge(first, next);
            return second;
        }
    }
    
}
