class Solution {
    public int solve(int[] nums,int n,int t,int m){
        int l=solve1(nums,n);
        int h=solve2(nums,n);
        int ll=solve1(nums,n-t);
        int hh=solve2(nums,n+t);
        int ans=(hh-h)+(l-ll);
        return Math.min(m,ans)+(h-l);
    }
    public int solve1(int[] arr,int target){
        int l=0;
        int r=arr.length;
        while(l<r){
            int mid=(l+r)/2;
            if(arr[mid]<target){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
    public int solve2(int[] arr,long target){
        int l=0;
        int r=arr.length;
        while(l<r){
            int mid=(l+r)/2;
            if(arr[mid]<=target){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int ans=1;
        for(int i=0;i<nums.length-1;i++){
            ans=Math.max(ans,solve(nums,nums[i],k,numOperations));
            ans=Math.max(ans,solve(nums,nums[i]-k,k,numOperations));
            ans=Math.max(ans,solve(nums,nums[i]+k,k,numOperations));
        }
        return ans;
    }
}