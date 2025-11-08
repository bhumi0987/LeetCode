class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=i;j<n;j++){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                if(map.containsKey(target)&&map.getOrDefault(target,0)>(j-i+1)/2){
                    ans++;
                }
            }
        }
        return ans;
    }
}