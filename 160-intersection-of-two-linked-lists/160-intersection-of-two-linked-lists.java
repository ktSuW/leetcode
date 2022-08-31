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
/*
Time O(n)
Space O(1)
 Length can be either same or different
 1. First find the length for each LL A and LL B
 2. if A length > B legnth, then move A. so that it will become align with A
    if A length < B length, then move B.
    Once they are align and they might still not at the at the intersection. So move both
    return headA.
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
        // find the length of both linked lists
        int a = findLength(headA);
        int b = findLength(headB);
        
        while( a > b){
            headA = headA.next;
            a --;
        }
        
        while(a < b){
            headB = headB.next;
            b--;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
        
    }
    

}