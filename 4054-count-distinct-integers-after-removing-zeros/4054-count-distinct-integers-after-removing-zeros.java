class Solution {
    public long countDistinct(long n) {
        String s=Long.toString(n);
        int m=s.length();
        long ans=0;
        long x=9;
        for(int i=1;i<m;i++){
            ans+=x;
            x*=9;
        }
        long[] dp=new long[m];
        dp[0]=1;
        for(int i=1;i<m;i++){
            dp[i]=dp[i-1]*9;
        }
        for(int i=0;i<m;i++){
            int y=s.charAt(i)-'0';
            if(y>1){
                ans+=(long)(y-1)*dp[m-i-1];
            }
            if(y==0){
                return ans;
            }
            if(i==m-1){
                ans++;
            }
        }
        return ans;
    }
}