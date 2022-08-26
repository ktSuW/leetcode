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
1. Iterate through the linked list and count all the linkedlist node
    if(curr.next != null), increment count

2. Find mid = count /2;
3. Find the result
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
        System.out.println("Count is " + count);
        System.out.println("Mid is "+ mid);
        // Odd length
        // [1, 2, 3]  
        if(count % 2 == 0){
            for(int i = 0; i < mid; i++){
                result = result.next;
            }
            return result;
        }

      // Even length
        // [1, 2, 3, 4]
        if(count % 2 != 0){
            for(int i = 0; i <= mid; i++){
                result = result.next;
            }
            return result;
        }
        return null;
    }
    
    1 2 3 4
    s
    f

    1 2 3 4
        s
             f
             
 If use fast and slow pointers approach, you don't have to worry about odd and even length;
} 
*/
class Solution {
    public ListNode middleNode(ListNode head) {
       ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}