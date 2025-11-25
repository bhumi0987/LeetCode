class Solution {
    public int solve(int i,int j,int curr,int target,int m,int n,int[][] cost,int[] houses,int[][][] dp){
        if(curr>target){
            return Integer.MAX_VALUE/2;
        }
        if(i==m){
            return curr==target?0:Integer.MAX_VALUE/2;
        }
        if(dp[i][j][curr]!=-1){
            return dp[i][j][curr];
        }
        int min=Integer.MAX_VALUE/2;
        if(houses[i]==0){
            for(int k=0;k<n;k++){
                if(j==k+1){
                    min=Math.min(min,cost[i][k]+solve(i+1,j,curr,target,m,n,cost,houses,dp));
                }else{
                    min=Math.min(min,cost[i][k]+solve(i+1,k+1,curr+1,target,m,n,cost,houses,dp));
                }
            }
        }
        else{
            if(j==houses[i]){
                min=Math.min(min,solve(i+1,houses[i],curr,target,m,n,cost,houses,dp));
            }else{
                min=Math.min(min,solve(i+1,houses[i],curr+1,target,m,n,cost,houses,dp));
            }
        }
        return dp[i][j][curr]=min;
    }
    public int minCost(int[] houses, int[][] cost,int m,int n,int target){
        int[][][] dp=new int[m][n+1][target+1];
        for(int a=0;a<m;a++){
            for(int b=0;b<=n;b++){
                Arrays.fill(dp[a][b],-1);
            }
        }
        int min=solve(0,0,0,target,m,n,cost,houses,dp);
        return min>=Integer.MAX_VALUE/3?-1:min;
    }
}
