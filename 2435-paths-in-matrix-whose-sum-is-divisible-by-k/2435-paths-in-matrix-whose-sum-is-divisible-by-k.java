class Solution {
    long mod=1000000007;
    public long solve(int i,int j,int sum,int[][] grid,int k,long[][][] dp){
        if(i>=grid.length||j>=grid[0].length||i<0||j<0){
            return 0;
        }
        if(dp[i][j][sum]!=-1){
            return dp[i][j][sum];
        }
        if(i==grid.length-1&&j==grid[0].length-1){
            if((sum+grid[i][j])%k==0){
                return 1;
            }
            return 0;
        }
        long right=solve(i,j+1,(sum+grid[i][j])%k,grid,k,dp);
        long down =solve(i+1,j,(sum+grid[i][j])%k,grid,k,dp);
        return dp[i][j][sum]=(right+down)%mod;
    }
    public int numberOfPaths(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        long[][][] dp=new long[n][m][k+1];
        for(long[][] it:dp){
            for(long[] it1:it){
                Arrays.fill(it1,(long)-1);
            }
        }
        return (int)solve(0,0,0,grid,k,dp);
    }
}