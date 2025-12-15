class Solution {
    public long solve(int i,int[] prices,long[] dp){
        if(i==0){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        if(prices[i]==prices[i-1]-1){
            dp[i]=1+solve(i-1,prices,dp);
        }else{
            dp[i]=1L;
        }
        return dp[i];
    }
    public long getDescentPeriods(int[] prices) {
        int n=prices.length;
        long[] dp=new long[n];
        long ans=0;
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            ans+=solve(i,prices,dp);
        }
        return ans;
    }
}