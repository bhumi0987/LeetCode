class Solution {
    public int mod=(int)1e9+7;
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public int solve(int i,int curr,int n,int m,int[][] mat,int[][] dp){
        if(i==n){
            if(curr==1){
                return 1;
            }
            return 0;
        }
        if(dp[i][curr]!=-1){
            return dp[i][curr];
        }
        long ans=0;
        for(int j=0;j<m;j++){
            int next=gcd(curr,mat[i][j]);
            ans=(ans+solve(i+1,next,n,m,mat,dp))%mod;
        }
        return dp[i][curr]=(int)ans;
    }
    public int countCoprime(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] dp=new int[n][151];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,0,n,m,mat,dp);
    }
}