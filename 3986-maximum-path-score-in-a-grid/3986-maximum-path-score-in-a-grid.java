class Solution {
    public int solve(int[][] grid,int k,int i,int j,int[][][] dp){
        if(i>=grid.length||j>=grid[0].length){
            return -1000000000;
        }
        int score=0;
        if(grid[i][j]==1){
            score++;
            k--;
        }
        if(grid[i][j]==2){
            score+=2;
            k--;
        }else{
            k-=0;
            score+=0;
        }
        if(k<0){
            return -1000000000;
        }
        if(i==grid.length-1&&j==grid[0].length-1){
            return score;
        }
        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }
        int op1=solve(grid,k,i+1,j,dp);
        int op2=solve(grid,k,i,j+1,dp);
        return dp[i][j][k]=score+Math.max(op1,op2);
    }
    public int maxPathScore(int[][] grid, int k) {
        int[][][] dp=new int[grid.length][grid[0].length][k+1];
        for(int[][] it:dp){
            for(int[] it1:it){
                Arrays.fill(it1,-1);
            }
        }
        int ans=solve(grid,k,0,0,dp);
        return ans<0?-1:ans;
    }
}