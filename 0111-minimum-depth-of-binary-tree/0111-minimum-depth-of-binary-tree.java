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
    class pair{
        TreeNode node;
        int dist;
        public pair(TreeNode node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<pair> q=new LinkedList<>();
        int min=Integer.MAX_VALUE;
        q.add(new pair(root,1));
        while(!q.isEmpty()){
            pair curr=q.poll();
            TreeNode node=curr.node;
            int dist=curr.dist;
            if(node.left==null&&node.right==null){
                min=Math.min(dist,min);
            }
            if(node.left!=null){
                q.add(new pair(node.left,dist+1));
            }
            if(node.right!=null){
                q.add(new pair(node.right,dist+1));
            }
        }
        return min;
    }
}