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

/*
Can solve this problem using either iterative or recursive approach. 
// Recursive Approach 
//----------------------------
1. Base case list1 is null , list2 is null
2. Walk towards the base case
    - list1.val < list2.val , then move list1 node to list1.next and keep comparing with list2
    - else 
        move list2

Time O(n + m)
Space O(m + n) due to recursive call stack use 

*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // dummy node is to keep head address 
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        // There might be nodes left 
        // to cover this case
        if(l1 == null){
            curr.next = l2;
        }else{
            curr.next = l1;
        }
        return dummy.next;
    }
}