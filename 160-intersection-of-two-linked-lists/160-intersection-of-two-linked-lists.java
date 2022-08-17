/*
First Approach
=======================
Use Two pointers approach
Initialise headA to pointerA
Intitialise headB to pointB -pB

while pA != pB
- if pA is not null. Move to the next node
- else there is no more node in headA ListNode, therefore, assign headB to pA

- if pB is not null, Move to the next node
- else there is no more node in headB.

- by the end of while loop, if there is no intersection, pA.next will be null. 
Therefore it will give a correct answer
Time complexity : O(n)
Space Complexity : O(1)

*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Two pointers appraoch 
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            if(pA != null){
               pA= pA.next; 
            }else{
                pA = headB;
            }
            if(pB != null){
                pB = pB.next;
            }else{
                pB = headA;
            }
        }
        return pA;
    }
}

