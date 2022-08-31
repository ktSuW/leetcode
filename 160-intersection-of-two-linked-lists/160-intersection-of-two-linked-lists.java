/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int findLength(ListNode node){
        int length = 0;
        while(node != null){
            node = node.next;
            length++;
        }
        return length;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Step 1: Find length 
        int a = findLength(headA);
        int b = findLength(headB);
        
        // Compare the len and move 
        while(a > b){
            headA = headA.next;
            a--;
        }
        
        while(a < b){
            headB = headB.next;
            b--;
        }
        
        while( headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}











