class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int ans=0;
        int[] left=new int[n];
        int[] right=new int[n];
        for(int i=1;i<n;i++){
            left[i]=left[i-1]+nums[i-1];
            right[n-i-1]=right[n-i]+nums[n-i];
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                continue;
            }
            if(left[i]==right[i]){
                ans+=2;
            }
            else if(Math.abs(left[i]-right[i])==1){
                ans+=1;
            }
        }
        return ans;
    }
}
