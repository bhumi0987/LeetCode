class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max=nums[0];
        for(int it:nums){
            max=Math.max(max,it);
        }
        max=max+k+2;
        int[] freq=new int[max];
        for(int it:nums){
            freq[it]++;
        }
        int[] pref=new int[max];
        pref[0]=freq[0];
        for(int i=1;i<max;i++){
            pref[i]=pref[i-1]+freq[i];
        }
        int ans=0;
        for(int i=0;i<max;i++){
            int left=Math.max(0,i-k);
            int right=Math.min(max-1,i+k);
            int res=pref[right];
            if(left>0){
                res-=pref[left-1];
            }
            ans=Math.max(ans,freq[i]+Math.min(numOperations,res-freq[i]));
        }
        return ans;
    }
}