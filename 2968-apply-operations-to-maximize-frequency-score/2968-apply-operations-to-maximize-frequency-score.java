class Solution {
    public long solve(int l,int r,int[] nums,long[] pre){
        int mid=(r+l)/2;
        long first=pre[mid];
        if(l>0){
            first-=pre[l-1];
        }
        long ans=(1L*nums[mid]*(mid-l+1))-first;
        long second=pre[r]-pre[mid];
        ans+=second-(1L*nums[mid]*(r-mid));
        return ans;
    }
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int n=nums.length;
        long[] pre=new long[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=nums[i]+pre[i-1];
        }
        int max=0;
        for(int i=0;i<n;i++){
            int low=i;
            int high=n-1;
            int ans=-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(solve(i,mid,nums,pre)<=k){
                    ans=mid;
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            if(ans!=-1){
                max=Math.max(max,ans-i+1);
            }
        }
        return max;
    }
}