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
//         List<Integer> result = new ArrayList<>();
//         Stack<TreeNode> stack = new Stack<>();
//         if(root == null) return result;
        
//         stack.add(root);
//         while(!stack.isEmpty()){
//             TreeNode node = stack.pop();
//             if (node != null) {
//             result.add(node.val);
//             stack.add(node.right);
//             stack.add(node.left);
//         }
            

//         }
//         return result;
        
        // Recursive approach 
        List<Integer> result = new ArrayList<>();
        helper(result, root);      
        return result;
    }
    
    private List<Integer> helper(List<Integer> result, TreeNode root){
        if (root == null) return result;
        result.add(root.val);
        helper(result, root.left );
        helper(result, root.right);
        return result;
    }
}