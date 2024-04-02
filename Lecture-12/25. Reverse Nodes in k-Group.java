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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)    return head;
        ListNode ans=new ListNode(0), my=ans, temp=head;
        while(temp!=null){
            ListNode start=temp;
            int i=0;
            for(;temp!=null && i<k;i++){
                temp=temp.next;
            }
            
            //does not contains k nodes
            if(i<k) my.next=start;
            //contains k nodes then reverse and add
            else my.next = reverse(start,temp);
            
            //start is pointing to end
            // while(my.next!=null) my=my.next;
            my = start;
        }
        return ans.next;
    }
    ListNode reverse(ListNode root, ListNode end){
        if(root==null || root.next==null || root==end || root.next==end)   return root;
        ListNode temp = reverse(root.next,end);
        root.next.next=root;
        root.next=null;
        return temp;
    }
}
