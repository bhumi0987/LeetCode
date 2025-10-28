class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int target=nums2[m-1];
        boolean flag=false;
        int min=(int)1e9;
        for(int i=0;i<n;i++){
            min=Math.min(min,Math.abs(nums1[i]-target));
            min=Math.min(min,Math.abs(nums2[i]-target));
        }
        for(int i=0;i<n;i++){
            int mini=Math.min(nums1[i],nums2[i]);
            int maxi=Math.max(nums1[i],nums2[i]);
            if(mini<=target&&target<=maxi){
                flag=true;
                break;
            }
        }
        long ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.abs(nums1[i]-nums2[i]);
        }
        if(!flag){
            ans+=min;
        }
        return ans+1;
    }
}