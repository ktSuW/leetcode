/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
There could be two approaches: 
Appraoch -1 : Iterate through the given linkedlist and add each node into the HashSet
If the node has been added, we have a cycle, 
By the end of the ListNode and if we cannot find the node then, there is not cycle

Approach - 2. Use two pointers approach - fast and slow
https://dev.to/alisabaj/floyd-s-tortoise-and-hare-algorithm-finding-a-cycle-in-a-linked-list-39af

https://medium.com/@tuvo1106/the-tortoise-and-the-hare-floyds-algorithm-87badf5f7d41
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        // constraints the number of the nodes can be between 0 and 10^4.
        // To cover this edge case
        if(head == null || head.next == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) return true;
        }
        return false;
    }
}