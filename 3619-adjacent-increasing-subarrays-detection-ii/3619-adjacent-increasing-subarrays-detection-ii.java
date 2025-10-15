class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size();
        int[] pre=new int[n+1];
        int[] suff=new int[n+1];
        for(int i=1;i<=n;i++){
            pre[i]=(i>1&&nums.get(i-2)<nums.get(i-1))?pre[i-1]+1:1;
        }
        for(int i=n;i>0;i--){
            suff[i]=(i<n&&nums.get(i-1)<nums.get(i))?suff[i+1]+1:1;
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            ans=Math.max(ans,Math.min(pre[i-1],suff[i]));
        }
        return ans;
    }
}