public class LinkedListAdd {
	

	 private class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(0);
    	ListNode current = dummy;
    	int remainder = 0;
    	int x = 0, y =0;
    	while(l1 != null || l2 != null)
    	{
    		if(l1 == null)
    			x = 0;
    		else
    		x = l1.val;
    		if(l2 == null)
    			y = 0;
    		else
    		y = l2.val;
    		int compute = x + y + remainder;
    		remainder = compute / 10;
    		current.next = new ListNode(compute % 10);
    		current = current.next;
    		if(l1 == null)
    			l1 = l1;
    		else
    		l1 = l1.next;
    		if(l2 == null)
    			l2 = l2;
    		else
    		l2 = l2.next;
    		}
    	if(remainder > 0)
    		current.next = new ListNode(remainder);
    	return dummy.next;
    }

	public static void main(String[] args) {
		int x = 4;
		int y = 3;
		System.out.println((x+y) %10);

	}

}
