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
    public boolean hasCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        // fast must be the one you need to check for null value 
        // since it move twice as fast compared to slow
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) return true;
        }
        return false;
    }
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Hashset appraoch 
        // Time O(n)
        // Space O(n) due to using set 
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
                head = head.next;
            }
            
        }
        return false;
    }
}