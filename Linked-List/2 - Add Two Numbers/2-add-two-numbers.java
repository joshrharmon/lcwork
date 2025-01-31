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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, temp;
        ListNode preHead = new ListNode(), cur = preHead;
        
        while(l1 != null || l2 != null)
        {
            if(l1 == null && l2 != null || l2 == null && l1 != null)
            {
                temp = l1 == null ? l2.val + carry : l1.val + carry;
            }
            else
            {
                temp = l1.val + l2.val + carry;
            }
            
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            
            carry = 0;
            
            if(temp > 9)
            {
                carry = 1;
                if(l1 == null && l2 == null)
                {
                    cur.next = new ListNode(temp % 10);
                    cur.next.next = new ListNode(carry);
                    cur = cur.next.next;
                }
                else
                {
                    cur.next = new ListNode(temp % 10);
                    cur = cur.next;
                }
            }
            else
            {
                cur.next = new ListNode(temp);
                cur = cur.next;
            }
            
        }
        return preHead.next;
    }
}
