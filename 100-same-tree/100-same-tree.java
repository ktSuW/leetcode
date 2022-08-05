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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case 
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;
        else if (p.val != q.val) return false;
        // Use BFS since I can break out from the loop early if I can the node with different datas in the top levels
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            int size = queue1.size();
            for(int i = 0; i < size; i++){
                p = queue1.poll();
                q = queue2.poll();
                if(p.val != q.val) return false;
                
                if(p.left != null && q.left != null){
                    queue1.add(p.left);
                    queue2.add(q.left);
                }else if(p.left == null && q.left != null){
                    return false;
                }else if(p.left != null && q.left == null){
                    return false;
                }
                
                if(p.right != null && q.right != null ){
                    queue1.add(p.right);
                    queue2.add(q.right);
                }else if(p.right == null && q.right != null){
                    return false;
                }else if(p.right != null && q.right == null){
                    return false;
                }
            }
        }
        return true;
    }
}
















