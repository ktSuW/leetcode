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
    public List<Integer> preorderTraversal(TreeNode root) {
        // Iterative approach 
        // preorder : visit order - root , left , right
        // Will use stack. LIFO
        // Therefore, right node must be added to the stack first so that I can visit left node
        // Time O(n)
        // Space O(n) due to stack data structure 
        List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()){
            root = stack.pop();
            preorder.add(root.val);
            
            if(root.right != null){
                stack.push(root.right);
            }
            
            if(root.left != null){
                stack.push(root.left);
            }
        }
        return preorder;
        
        //=========================================
        // Time O(n)
        // Space O(n)
        // Recursive approach 
//         List<Integer> result = new ArrayList<>();
//         helper(result, root);      
//         return result;
//     }
    
//     private List<Integer> helper(List<Integer> result, TreeNode root){
//         if (root == null) return result;
//         result.add(root.val);
//         helper(result, root.left );
//         helper(result, root.right);
//         return result;
    }
}