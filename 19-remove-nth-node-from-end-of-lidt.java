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
        ListNode ep = head;
        for (int i = 0; i < n; i++) {
            ep = ep.next;
            if (ep == null) return i == n - 1 ? head.next : head;
        }

        ListNode prev = head;

        while (ep.next != null) {
            ep = ep.next;
            prev = prev.next;
        }

        ListNode deleted = prev.next;
        prev.next = deleted.next;
        deleted.next = null;
        return head;
    }
}
