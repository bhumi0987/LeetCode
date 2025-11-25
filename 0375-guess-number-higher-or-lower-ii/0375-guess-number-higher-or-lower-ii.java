class Solution {
    public int solve(int l,int r,int[][] dp){
        if(l>=r){
            return 0;
        }
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        int min=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            min=Math.min(min,i+Math.max(solve(l,i-1,dp),solve(i+1,r,dp)));
        }
        return dp[l][r]=min;
    }
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(1,n,dp);
    }
}