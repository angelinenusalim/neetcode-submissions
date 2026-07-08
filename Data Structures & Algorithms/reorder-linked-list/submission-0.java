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
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        curr = head;
        ListNode first = curr;
        for (int i = 0; i < len/2 + 1; i++) {
            curr = curr.next;
        }

        curr = head;
        for (int i = 0; i < len - len/2 - 1; i++) {
            curr = curr.next;
        }
        ListNode second = curr.next;
        curr.next = null;
        ListNode rev = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = rev;
            rev = second;
            second = temp;
        }
        while (rev != null) {
            ListNode nextFirst = first.next;
            ListNode nextSecond = rev.next;
            first.next = rev;
            rev.next = nextFirst;
            first = nextFirst;
            rev = nextSecond;
        }
        head = first;
        return;

    }
}
