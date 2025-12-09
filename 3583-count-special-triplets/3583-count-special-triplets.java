class Solution {
    public int specialTriplets(int[] nums) {
        int mod=1000000007;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> map1=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)-1);
            int x=map1.getOrDefault(nums[i]*2,0);
            int y=map.getOrDefault(nums[i]*2,0);
            count=(int)((count+1L*x*y)%mod);
            map1.put(nums[i],map1.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
}