class Solution {
    public int maxBalancedSubarray(int[] nums) {
        Map<String,Integer> map=new HashMap<>();
        int ans=0;
        int count=0;
        int max=0;
        map.put("0#0",-1);
        for(int i=0;i<nums.length;i++){
            ans^=nums[i];
            if(nums[i]%2==0){
                count++;
            }else{
                count--;
            }
            String key=ans+"#"+count;
            if(map.containsKey(key)){
                int start=map.get(key);
                max=Math.max(max,i-start);
            }else{
                map.put(key,i);
            }
        }
        return max;
    }
}