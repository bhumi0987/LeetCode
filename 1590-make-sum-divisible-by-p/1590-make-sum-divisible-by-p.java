class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            sum=(sum+num)%p;
        }
        int target=sum%p;
        if(target==0){
            return 0;
        }
        int curr=0;
        int min=nums.length;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            curr=(curr+nums[i])%p;
            int needed=(curr-target+p)%p;
            if(map.containsKey(needed)){
                min=Math.min(min,i-map.get(needed));
            }
            map.put(curr,i);
        }
        return (min!=nums.length)?min:-1;
    }
}