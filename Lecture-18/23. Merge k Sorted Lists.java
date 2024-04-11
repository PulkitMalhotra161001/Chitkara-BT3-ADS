/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode ans=lists[0];
        
        for(int i=1;i<lists.length;i++){
            ans=merge(ans,lists[i]);
        }
        return ans;
    }
     public ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                current.next = h1;
                h1 = h1.next;
            } else {
                current.next = h2;
                h2 = h2.next;
            }
            current = current.next;
        }
        
        if (h1 != null) {
            current.next = h1;
        }
        
        if (h2 != null) {
            current.next = h2;
        }
        
        return dummy.next;
    }
}
