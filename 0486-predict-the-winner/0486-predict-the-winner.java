class Solution {
    public int solve(int i,int j,boolean flag,int[] nums){
        if(i>j){
            return 0;
        }
        int ans=0;
        if(flag){
            int pick=nums[i]+solve(i+1,j,false,nums);
            int notpick=nums[j]+solve(i,j-1,false,nums);
            ans=Math.max(pick,notpick);
        }else{
            int pick=-nums[i]+solve(i+1,j,true,nums);
            int notpick=-nums[j]+solve(i,j-1,true,nums);
            ans=Math.min(pick,notpick);
        }
        return ans;
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        int ans=solve(i,j,true,nums);
        return ans>=0;
    }
}