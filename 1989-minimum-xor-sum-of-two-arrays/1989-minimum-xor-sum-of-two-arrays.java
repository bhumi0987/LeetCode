class Solution {
    Integer[][] dp;
    public int solve(int idx,int mask,int[] nums1,int[] nums2){
        if(idx==nums1.length){
            return 0;
        }
        if(dp[idx][mask]!=null){
            return dp[idx][mask];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums2.length;i++){
            if((mask>>i&1)==1){
                continue;
            }
            int sum=(nums1[idx]^nums2[i])+solve(idx+1,mask|(1<<i),nums1,nums2);
            ans=Math.min(sum,ans);
        }
        return dp[idx][mask]=ans;
    }
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n=nums1.length;
        dp=new Integer[n][1<<n];
        return solve(0,0,nums1,nums2);
    }
}