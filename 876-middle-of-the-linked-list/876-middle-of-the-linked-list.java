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
    public ListNode middleNode(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while(curr.next != null){
            curr = curr.next;
            count++;
        }
        
        int mid = count/2;
        ListNode result = head;
        // Even length
        if(count % 2 == 0){
            for(int i = 0; i < mid; i++){
                result = result.next;
            }
            return result;
        }
        // Odd length
        if(count % 2 != 0){
            for(int i = 0; i <= mid; i++){
                result = result.next;
            }
            return result;
        }
        return null;
    }
}