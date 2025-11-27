class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] prefix=new long[k];
        Arrays.fill(prefix,Long.MAX_VALUE);
        prefix[k-1]=0;
        long ans=Long.MIN_VALUE;
        long pre=0;
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            if(prefix[i%k]!=Long.MAX_VALUE){
                ans=Math.max(ans,pre-prefix[i%k]);
            }
            prefix[i%k]=Math.min(prefix[i%k],pre);
        }
        return ans;
    }
}