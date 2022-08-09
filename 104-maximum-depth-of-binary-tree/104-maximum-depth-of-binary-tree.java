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
// since is depth
// 3
// size is 1
// size 0
// result 1
//========================
// queue 9, 20
// size = 2
// for 9,there is not left and right
// queue 15 7 
//=====================
// 
class Solution {
    public int maxDepth(TreeNode root) {
        int result =0;
        if(root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
                size--;
            }
            result++;
        }
        return result;
    }
}