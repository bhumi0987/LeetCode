class Solution {
    public int solve(int idx,int prev,int[][] dp,String[] strs,int n){
        if(idx==n){
            return 0;
        }
        if(prev>=0&&dp[idx][prev]!=-1){
            return dp[idx][prev];
        }
        boolean flag=true;
        if(prev!=-1){
            for(String str:strs){
                if(str.charAt(prev)>str.charAt(idx)){
                    flag=false;
                    break;
                }
            }
        }
        int pick=Integer.MAX_VALUE;
        if(flag){
            pick=solve(idx+1,idx,dp,strs,n);
        }
        int notpick=1+solve(idx+1,prev,dp,strs,n);
        if(prev!=-1){
            return dp[idx][prev]=Math.min(pick,notpick);
        }
        return Math.min(pick,notpick);
    }
    public int minDeletionSize(String[] strs) {
        int n=strs[0].length();
        int[][] dp=new int[n+1][n+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,-1,dp,strs,n);
    }
}