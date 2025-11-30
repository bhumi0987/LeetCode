class Solution {
    private int upper(int[] a,int x){
        int l=0;
        int r=a.length;
        while(l<r){
            int m=l+(r-l)/2;
            if(a[m]<=x){
                l=m+1;
            }else{
                r=m;
            }
        }
        return l;
    }
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int x=upper(nums,nums[i]); 
            if(n-x>=k){
                ans++;
            }
        }
        return ans;
    }
}