class Solution {
    public long maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        long max=(long)nums[n-1]*(long)nums[n-2]*100000L;
        max=Math.max(max,(long)nums[0]*-100000L*(long)nums[n-1]);
        max=Math.max(max,(long)nums[0]*(long)nums[1]*100000L);
        return max;
    }
}