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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headAns = head, curNode = head, curNodeDelay = head;
        int cur = 0;
        
        while(curNode != null)
        {
        	ListNode temp;
        	if(cur == n)	
        	{
				if(curNode)
        	}
        	curNode = curNode.next;
        }
        
        return headAns;
    }
}
