/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Recursive approach 
    // left root right 
    // therefore add root when I see for the second time 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, result);
        return result;
    }
    
    private List<Integer> helper(TreeNode root, List<Integer> result){
        if(root == null) return result;
        
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
        return result;
    }
}