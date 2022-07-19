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
    public ListNode mergeKLists(ListNode[] lists) {
        // Use k pointers to find the sorted elements in the lists given
        // Every single pointer starts from left end of each sorted linked list 
        // if they are k-sorted linked list
        // Use this concept => use Min heap => smallest value at the top of the node of binary tree.
        // Enque and dequeue that smallest one 
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val)); // Comparator, needs to compare
        // Iterate through 
        for(ListNode head : lists){
            if(head != null){
                minHeap.offer(head);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!minHeap.isEmpty()){
            ListNode curr = minHeap.poll();
            head.next = new ListNode(curr.val);
            // then move the pointer
            if(curr.next != null){
                minHeap.add(curr.next);
            }
            head = head.next;
        }
        return dummy.next;
        
    }
}