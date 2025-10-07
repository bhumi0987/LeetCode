class Solution {
    public int solve(int[][] queries,int i,int target,int k,int[][] dp){
        if(target==0){
            return k;
        }
        if(k>=queries.length||target<0){
            return queries.length+1;
        }
        if(dp[target][k]!=-1){
            return dp[target][k];
        }
        int ans=solve(queries,i,target,k+1,dp);
        if(queries[k][0]<=i&&i<=queries[k][1]){
            ans=Math.min(ans,solve(queries,i,target-queries[k][2],k+1,dp));
        }
        return dp[target][k]=ans;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            int[][] dp=new int[nums[i]+1][queries.length];
            Arrays.stream(dp).forEach(row->Arrays.fill(row,-1));
            ans=Math.max(ans,solve(queries,i,nums[i],0,dp));
        }
        return (ans>queries.length)?-1:ans;
    }
}