/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * 1 -> 2 -> 3 6 -> 5 -> 4 -> null
 * 1 -> 6 -> 2 -> 5 -> 3 -> 4
 * 
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
        	return;
        } else {
        	ListNode slow = head, fast = head;
        	
        	// find middle of list 
        	while(fast != null && fast.next != null) {
        		slow = slow.next;
        		fast = fast.next.next;
        	}
        	
        	// reverse latter half
        	ListNode cur = slow, prev = null, tmp;
        	while(cur != null) {
        		tmp = cur.next;
        		cur.next = prev;
        		prev = cur;
        		cur = tmp;
        	}
        	
        	// merge
        	ListNode first = head, second = prev;
        	while(second.next != null) {
        		tmp = first.next;
        		first.next = second;
        		first = tmp;
        		
        		tmp = second.next;
        		second.next = first;
        		second = tmp;
        	}
        }
    }
}
