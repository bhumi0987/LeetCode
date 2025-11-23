class Solution {
    public int solve(int i,int sum,int[] nums,int[][] dp){
        if(i>=nums.length){
            if(sum==0){
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }
        int pick=nums[i]+solve(i+1,(sum+nums[i])%3,nums,dp);
        int notpick=solve(i+1,sum,nums,dp);
        return dp[i][sum]=Math.max(pick,notpick);
    }
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][3];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,0,nums,dp);
    }
}