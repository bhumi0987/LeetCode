class Solution {
    public boolean solve1(String s,int m,int n,int[] count){
        int zero=0;
        int one=0;
        for(char c:s.toCharArray()){
            if(c=='1'){
                one++;
            }
            else zero++;
        }
        count[0]=zero;
        count[1]=one;
        return zero<=m&&one<=n;
    }
    public int solve(String[] strs,int m,int n,int idx,int[][][] dp){
        if(idx<0){
            return 0;
        }
        if(dp[idx][m][n]!=-1){
            return dp[idx][m][n];
        }
        int pick=0;
        int[] count=new int[2];
        if(solve1(strs[idx],m,n,count)){
            pick=1+solve(strs,m-count[0],n-count[1],idx-1,dp);
        }
        int notpick=solve(strs,m,n,idx-1,dp);
        return dp[idx][m][n]=Math.max(pick,notpick);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int x=strs.length;
        int[][][] dp=new int[x][m+1][n+1];
        for(int[][] it:dp){
            for(int[] it1:it){
                Arrays.fill(it1,-1);
            }
        }
        return solve(strs,m,n,x-1,dp);
    }
}