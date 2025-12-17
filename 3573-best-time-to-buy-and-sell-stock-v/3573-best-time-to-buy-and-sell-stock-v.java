class Solution {
    public long solve(int i,int j,int decider,int n,int[] prices,Long[][][] dp){
        if(i==n){
            if(j>=0&&decider==0){
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        if(dp[i][j][decider]!=null){
            return dp[i][j][decider];
        }
        long pick=Integer.MIN_VALUE;
        long notpick=Integer.MIN_VALUE;
        if(j>0){
            if(decider==1){
                pick=prices[i]+solve(i+1,j-1,0,n,prices,dp);
            }else if(decider==2){
                pick=-prices[i]+solve(i+1,j-1,0,n,prices,dp);
            }else{
                pick=Math.max(prices[i]+solve(i+1,j,2,n,prices,dp),-prices[i]+solve(i+1,j,1,n,prices,dp));
            }
        }
        notpick=solve(i+1,j,decider,n,prices,dp);
        return dp[i][j][decider]=Math.max(pick,notpick);
    }
    public long maximumProfit(int[] prices, int k) {
        long ans=0;
        int n=prices.length;
        Long[][][] dp=new Long[n][k+1][3];
        return solve(0,k,0,n,prices,dp);
    }
}