class Solution {
    public int longestBalanced(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> even=new HashSet<>();
            HashSet<Integer> odd=new HashSet<>();
            int temp=i;
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2==0){
                    even.add(nums[j]);
                }else{
                    odd.add(nums[j]);
                }
                if(odd.size()==even.size()){
                max=Math.max(max,j-i+1);
            }
            }
        }
        return max;
    }
}