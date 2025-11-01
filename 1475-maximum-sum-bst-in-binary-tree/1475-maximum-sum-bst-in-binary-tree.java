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
class pair{
    TreeNode node;
    int sum;
    int max;
    int min;
    boolean flag=true;
    public pair(TreeNode node){
        this.node=node;
        this.sum=node.val;
        this.max=node.val;
        this.min=node.val;
    }
}
class Solution {
    int sum=0;
    public pair solve(TreeNode root){
        if(root==null){
            return null;
        }
        pair left=solve(root.left);
        pair right=solve(root.right);
        pair curr=new pair(root);
        if(left!=null){
            curr.sum+=left.sum;
            curr.max=Math.max(left.max,root.val);
            curr.min=Math.min(left.min,root.val);
            curr.flag=left.flag&&left.max<root.val;
        }
        if(right!=null){
            curr.sum+=right.sum;
            curr.max=Math.max(right.max,curr.max);
            curr.min=Math.min(right.min,curr.min);
            curr.flag&=right.flag&&right.min>root.val;
        }
        if(curr.flag){
            sum=Math.max(sum,curr.sum);
        }
        return curr;
    }
    public int maxSumBST(TreeNode root) {
        solve(root);
        return sum;
    }
}