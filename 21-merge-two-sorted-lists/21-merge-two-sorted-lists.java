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
1. Base case list1 is null , list2 is null
2. Walk towards the base case
    - list1.val < list2.val , then move list1 node to list1.next and keep comparing with list2
    - else 
        move list2
3. Vistualise recursive call stack
    
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // base case 
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        // walk towards the base case
        if(l1.val < l2.val){
   
            l1.next =  mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
 
    }
}