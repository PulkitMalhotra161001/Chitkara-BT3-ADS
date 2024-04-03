public ListNode reverseList(ListNode head) {
      if(head==null || head.next==null)  return head;
      
      ListNode ans = reverseList(head.next);
      head.next.next=head;
      head.next=null;
      
      return ans;
  }

public ListNode reverseList(ListNode head) {
    ListNode dummy=null;
    ListNode temp=head;
    while(temp!=null){
        temp=head.next;
        head.next=dummy;
        dummy=head;
        head=temp;
    }
    return dummy;
}
