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
        boolean hasToAdd = false;
        ListNode result = null;
        ListNode pointer = null;
        while (l1 != null || l2 != null || hasToAdd) {
            int n1 = 0;
            int n2 = 0;

            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }

            int newVal = n1 + n2 + (hasToAdd ? 1 : 0);
            hasToAdd = newVal > 9;
            ListNode newNode = new ListNode(newVal % 10);
            if (pointer == null) {
                result = newNode;
                pointer = newNode;
            } else {
                pointer.next = newNode;
                pointer = newNode;
            }
            
        }
        return result;
    }
}
