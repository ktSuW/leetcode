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

Use two pointers approach to solve this problem
        head                    tail
        1 --> 2 --> 3 ---> 4 --> 5
prev
        curr
        Before breaking the link between 1 and 2, I need to keep where is 2 is in the memoery. So I need to store it.
        
 Two pointers approach
 =====================
 - prev
 - curr 
        head                    tail
        1 --> 2 --> 3 ---> 4 --> 5
prev    ^
        curr
        
        head                    tail
        1 --> 2 --> 3 ---> 4 --> 5
prev    ^
        curr.next is 2. Save it in the temporary node 
        Now I can break the link between 1 and 2
        
        curr.next => make it point to prev which is null
        
                            tail
prev <-- 1 --> 2 --> 3 ---> 4 --> 5
After this. move prev to curr
             and curr pointer to curr.next
null <-- 1 --> 2 --> 3 ---> 4 --> 5
        
        prev   curr
        Do the same step
        
null <-- 1 <-- 2 --> 3 ---> 4 --> 5
        
              prev   curr    
              
null <-- 1 <-- 2 <-- 3 ---> 4 --> 5
        
                    prev   curr  
                    
null <-- 1 <-- 2 <-- 3 <-- 4 --> 5
        
                           prev  curr
null <-- 1 <-- 2 <-- 3 <-- 4 <-- 5
                                 prev

By the end of this, prev will become a new head and return it
 
 // Time complexity O(n)
// Space complexity O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
*/
// Time complexity O(n)
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode nextNode = curr.next;
        curr.next = null;
        ListNode finalHead = reverseList(nextNode);
        nextNode.next = curr;
        return finalHead;
    }
}