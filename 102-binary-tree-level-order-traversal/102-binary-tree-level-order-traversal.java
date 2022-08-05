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
// Time O(n)
// space O(n) - worst case 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return result;
        queue.offer(root);
        // for each level, get queue size. 
        // Into the queue, add popped element's left and right children if there are
        // After each level, add the result into the final result
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                root = queue.poll();
                level.add(root.val);
                
                // check for root.left
                if(root.left != null){
                    queue.add(root.left);
                }
                
                if(root.right != null){
                    queue.add(root.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}