class Solution {
    public int findMaximumLength(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        long[] pre=new long[n+1];
        for(int i=1;i<=n;i++){
            pre[i]=pre[i-1]+nums[i-1];
        }
        List<long[]> arr=new ArrayList<>();
        arr.add(new long[]{0,0});
        for(int i=1;i<=n;i++){
            int low=0;
            int high=arr.size()-1;
            int ans=0;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(arr.get(mid)[0]<=pre[i]){
                    ans=mid;
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            int idx=(int)arr.get(ans)[1];
            dp[i]=dp[idx]+1;
            long x=2L*pre[i]-pre[idx];
            while(arr.size()>1&&arr.get(arr.size()-1)[0]>=x){
                arr.remove(arr.size()-1);
            }
            arr.add(new long[]{x,i});
        }
        return dp[n];
    }
}