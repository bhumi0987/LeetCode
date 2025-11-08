class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int sum=0;
        for(int it:nums){
            sum+=(max-it);
        }
        return sum;
    }
}