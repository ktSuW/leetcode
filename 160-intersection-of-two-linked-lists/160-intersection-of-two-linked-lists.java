
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

