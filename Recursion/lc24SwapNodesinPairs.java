public class lc24SwapNodesinPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        // Take second node and first node
        ListNode second = head.next;
        ListNode first = head;
        
        //call the function  to swap the rest of the list following the first two nodes
        first.next = swapPairs(first.next.next);
        second.next = first;
        
        return second;
        
    }
    public static void printList(ListNode head) { 
        ListNode n = head; 
        while (n != null) { 
            System.out.print(n.val + " "); 
            n = n.next; 
        } 
    } 
    public static void main(String[] argv) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printList(swapPairs(n1));

    }
    
}
