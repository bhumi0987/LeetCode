class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long ans=0;
        int prev=0;
        for(int i=0;i<nums.length;i++){
            int x=target[i]-nums[i];
            if(x<0&&prev>=0||x>0&&prev<=0){
                ans+=Math.abs(x);
            }else if(Math.abs(prev)<Math.abs(x)){
                ans+=Math.abs(x-prev);
            }
            prev=x;
        }
        return ans;
    }
}