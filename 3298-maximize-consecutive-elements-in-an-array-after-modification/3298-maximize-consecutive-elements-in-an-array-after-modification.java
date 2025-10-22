class Solution {
    public int solve(int[] nums,int i,int prev,Map<String,Integer> dp){
        if(i==nums.length){
            return 0;
        }
        String key=i+"-"+prev;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int ans=0;
        if(prev==-1||prev+1==nums[i]){
            ans=1+solve(nums,i+1,nums[i],dp);
        }
        if(prev==-1||prev==nums[i]){
            ans=Math.max(ans,1+solve(nums,i+1,nums[i]+1,dp));
        }
        if(prev==-1||prev>nums[i]){
            ans=Math.max(ans,solve(nums,i+1,prev,dp));
        }
        dp.put(key,ans);
        return ans;
    }
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<String,Integer> dp=new HashMap<>();
        return solve(nums,0,-1,dp);
    }
}