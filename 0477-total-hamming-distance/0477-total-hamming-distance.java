class Solution {
    public int totalHammingDistance(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<32;i++){
            int one=0;
            for(int it:nums){
                if((it&(1<<i))!=0){
                    one++;
                }
            }
            int zero=n-one;
            ans+=one*zero;
        }
        return ans;
    }
}