/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Iterative approach
// Space O(n)
// Space O(1)
// If I use recursion, Space will be O(n) due to recursive call stack use
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pValue = p.val;
        int qValue = q.val;
        
        TreeNode curr = root;
        while(curr != null){
            int currValue = curr.val;
            // Using BST property 
            // If both are greater, they must be on the right side of the current TreeNode
            if(pValue > currValue && qValue > currValue){
                curr = curr.right;
            }else if (pValue < currValue && qValue < currValue){
                curr = curr.left;
            }else{
                return curr;
            }
        }
        return curr;
    }
}