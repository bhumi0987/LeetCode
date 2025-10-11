class Solution {
    int mod=(int)1e9+7;
    public int solve(int idx,int n,int sum,int target,int[][] types,int[][] dp){
        if(sum==target){
            return 1;
        }
        if(sum>target){
            return 0;
        }
        if(idx==n){
            if(target==sum){
                return 1;
            }
            return 0;
        }
        if(dp[idx][sum]!=-1){
            return dp[idx][sum];
        }
        int pick=0;
        int notpick=0;
        for(int i=1;i<=types[idx][0];i++){
            pick=(pick+(solve(idx+1,n,sum+i*types[idx][1],target,types,dp))%mod)%mod;
        }
        notpick=(notpick+(solve(idx+1,n,sum,target,types,dp))%mod)%mod;
        return dp[idx][sum]=(pick+notpick)%mod;
    }
    public int waysToReachTarget(int target, int[][] types) {
        int n=types.length;
        int[][] dp=new int[types.length+1][target+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,n,0,target,types,dp)%mod;
    }
}