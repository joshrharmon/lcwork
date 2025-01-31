/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
        	return null;
        }
        
        Node cur = head, newHead, newCur = newHead;
        while(cur != null) {
        	newCur = new Node(cur.val);
        	newCur.next = new Node(cur.next.val);
        	newCur.random = new Node(cur.random.val);
        	
        	newCur = newCur.next;
        	cur = cur.next;
        }
        return newHead;
    }
}
