class Solution {
    int n;
    int m;
    int[][] dp;
    int min=-(int)1e7;
    int max=min;
    public int solve(int i,int j,List<List<Integer>> grid){
        if(i>=n&&j>=m){
            return min;
        }
        if(dp[i][j]!=min){
            return dp[i][j];
        }
        int x=grid.get(i).get(j);
        int down=min;
        int right=min;
        if(i!=n-1){
            down=grid.get(i+1).get(j)-x+Math.max(0,solve(i+1,j,grid));
        }
        if(j!=m-1){
            right=grid.get(i).get(j+1)-x+Math.max(0,solve(i,j+1,grid));
        }
        int ans=Math.max(down,right);
        dp[i][j]=ans;
        max=Math.max(max,dp[i][j]);
        return dp[i][j];
    }
    public int maxScore(List<List<Integer>> grid) {
        n=grid.size();
        m=grid.get(0).size();
        dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],min);
        }
        solve(0,0,grid);
        return max;
    }
}