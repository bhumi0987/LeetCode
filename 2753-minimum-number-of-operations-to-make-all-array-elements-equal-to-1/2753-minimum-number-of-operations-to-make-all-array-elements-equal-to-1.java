class Solution {
    public int solve(int a,int b){
        if(a==0){
            return b;
        }
        return solve(b%a,a);
    }
    public int minOperations(int[] nums) {
        int one=0;
        for(int it:nums){
            if(it==1){
                one++;
            }
        }
        if(one>0){
            return nums.length-one;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int gcd=nums[i];
            for(int j=i+1;j<nums.length;j++){
                gcd=solve(gcd,nums[j]);
                if(gcd==1){
                    ans=Math.min(ans,j-i+nums.length-1);
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}