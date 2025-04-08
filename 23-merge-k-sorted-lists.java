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

    ListNode resultH = null;
    ListNode resultP = null;

    LinkedList<Integer> sortedHeads = new LinkedList<>();

    private void addNode(ListNode node) {
        if (resultH == null) {
            resultH = node;
            resultP = node;
        } else {
            resultP.next = node;
            resultP = node;
        }
    }

    private void bubbleUpList(int listNo, ListNode[] lists) {
        ListNode list = lists[listNo];
        if (list == null) {
            return;
        }
        int j = 0;
        ListIterator<Integer> iterator = sortedHeads.listIterator();
        //while (j < sortedHeads.size() && lists[sortedHeads.get(j)].val < list.val) j++;  // also works
        while (iterator.hasNext()) {
            if (lists[iterator.next()].val > list.val) {
                break;
            }
            j++;
        }
        sortedHeads.add(j, listNo);
    }

    
    public ListNode mergeKLists(ListNode[] lists) {

        for (int listNo = 0; listNo < lists.length; listNo++) {
           bubbleUpList(listNo, lists);
        }

        while(sortedHeads.size() > 0) {
            Integer minListNo = sortedHeads.removeFirst();
            ListNode minList = lists[minListNo];
            ListNode minNode = minList;
            lists[minListNo] = minNode.next;
            minNode.next = null;
            addNode(minNode);
            bubbleUpList(minListNo, lists);
        }
        
        return resultH;
    }
}
