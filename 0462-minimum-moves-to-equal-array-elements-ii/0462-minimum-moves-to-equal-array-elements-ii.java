class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid=nums[nums.length/2];
        int min=0;
        for(int it:nums){
            min+=Math.abs(it-mid);
        }
        return min;
    }
}