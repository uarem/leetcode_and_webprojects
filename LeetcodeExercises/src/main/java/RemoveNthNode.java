/**
 * Created by uarem on 3/4/2015.
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ListNode offsetNode = head;
        int size = 1;
        for(int i=0; i<n; ++i) {
            ++size;
            offsetNode = offsetNode.next;
        }
        if(offsetNode == null) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }

        ListNode current = head;
        while(offsetNode.next != null) {
            ++size;
            offsetNode = offsetNode.next;
            current = current.next;
        }

        ListNode deleteNode = current.next;
        current.next = deleteNode.next;
        deleteNode.next = null;

        return head;
    }
}
