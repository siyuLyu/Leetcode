public class lc206ReverseLinkedList {
    // Time O(n) n is the length of node
    // Space O(n) call stack n level depth
    // 1->2->3->4->5
    //                       h   
    // newHead = reverse(2); 1 2->3->4->5
    //                         h
    // newHead = reverse(3); 1 2 3->4->5
    //                           h
    // newHead = reverse(4); 1 2 3 4->5
    //                             h
    // newHead = reverse(5); 1 2 3 4 5
    //  5  returned after recursion
    //   head.next.next = head; is confused because this is to reset head
    //   head = 4 head.next.next = null
    //           h  nh  h.next.next          
    //  1->2->3->4->5->null                  
    //  head.next = null clear the element after head
    //       nh h
    //       5->4   1->2->3
    //       nh     h
    //       5 ->4->3  1->2
    //       nh       h
    //       5->4->3->2 1
    //       nh          h
    //       5->4->3->2->1
    
    
    
    public ListNode reverseList(ListNode head) {
        //base case -> if no more node, the current node become head
        if (head == null || head.next == null) return head;
        //Recursive call
        ListNode newHead = reverseList(head.next);
        //reset head
        head.next.next = head;
        head.next = null;
        
        return newHead;
        
    }
}
