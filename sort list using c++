/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

ListNode* findMid(ListNode* &head) {

       ListNode* slow = head;
       ListNode* fast = head->next;

        while(fast && fast->next) {
            slow=slow->next;
             fast=fast->next->next;
        }
        return slow;
}

ListNode* merge(ListNode* l1, ListNode* l2) {
    if (l1 == nullptr) return l2;
    if (l2 == nullptr) return l1;

    ListNode* ans = new ListNode(-1);
    ListNode* ptr = ans;

    while (l1 != nullptr && l2 != nullptr) {
        if (l1->val <= l2->val) {
            ptr->next = l1;
            ptr = l1;
            l1 = l1->next;
        } else {
            ptr->next = l2;
            ptr = l2;
            l2 = l2->next;
        }
    }

    if (l1) {
        ptr->next = l1;
    }
    if (l2) {
        ptr->next = l2;
    }

    ListNode* mergedList = ans->next;
    delete ans; // Clean up the temporary node

    return mergedList;
}




class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if(head==0 || head->next==0){
            return head;
        }

        //find mid
        ListNode* mid=findMid(head);

        ListNode* left=head;
        ListNode* right=mid->next;
        mid->next=NULL;
        
        //sort both half LL using recursion
        left=sortList(left);
        right=sortList(right);

        //ab merge kar do sorted ll ko
        ListNode* mergeLL=merge(left,right);

        return mergeLL;
    }
};
