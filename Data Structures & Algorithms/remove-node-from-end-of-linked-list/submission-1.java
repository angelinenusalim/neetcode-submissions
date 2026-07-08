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
        int len = 0;
        ListNode curr = head;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }
        len++;
        if (len == 1) return null;
        int idx = len - n;
        if (idx == 0) return head.next;
        int count = 0;
        ListNode temp = head;
        for (int i = 0; i < idx; i++) {
            if (count == idx-1) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
            count++;
        }
        return head;
    }
}
