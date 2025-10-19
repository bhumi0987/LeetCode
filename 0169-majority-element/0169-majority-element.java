class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int ans=0;
        for(int it:nums){
            if(count==0){
                ans=it;
                count=1;
            }else if(it==ans){
                count++;
            }else{
                count--;
            }
        }
        int freq=0;
        for(int it:nums){
            if(it==ans){
                freq++;
            }
        }
        if(freq>nums.length/2){
            return ans;
        }
        return -1;
    }
}