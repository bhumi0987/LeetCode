class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i]=-nums[i];
            }
        }
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        long ans=0;
        while(i<j){
            int x=nums[i]*nums[i];
            int y=nums[j]*nums[j];
            ans+=(y-x);
            i++;
            j--;
        }
        if(nums.length%2!=0){
            int x=nums[i]*nums[i];
            ans+=x;
        }
        return ans;
    }
}