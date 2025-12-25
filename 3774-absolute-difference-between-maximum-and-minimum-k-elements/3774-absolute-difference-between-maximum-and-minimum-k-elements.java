class Solution {
    public int absDifference(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int sum=0;
        int sum1=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        for(int i=n-1;i>=n-k;i--){
            sum1+=nums[i];
        }
        return sum1-sum;
    }
}