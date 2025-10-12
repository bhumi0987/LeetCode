class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        if(n<=2){
            return n;
        }
        int max=2;
        int curr=2;
        for(int i=2;i<n;i++){
            if(nums[i]==nums[i-1]+nums[i-2]){
                curr++;
            }else{
                curr=2;
            }
            max=Math.max(max,curr);
        }
        return max;
    }
}