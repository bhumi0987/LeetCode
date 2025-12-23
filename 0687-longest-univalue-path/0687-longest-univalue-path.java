class Solution {
    int ans;
    public int solve(TreeNode root,int parent){
        if(root==null){
            return 0;
        }
        int left=solve(root.left,root.val);
        int right=solve(root.right,root.val);
        ans=Math.max(ans,left+right);
        return root.val==parent?Math.max(left,right)+1:0;
    }
    public int longestUnivaluePath(TreeNode root) {
        solve(root,-1);
        return ans;
    }
}