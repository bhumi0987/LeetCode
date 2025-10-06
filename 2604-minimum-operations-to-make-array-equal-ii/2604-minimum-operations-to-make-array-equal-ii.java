class Solution {
    public long minOperations(int[] nums1,int[] nums2,int k){
        if(k==0){
            for(int i=0;i<nums1.length;i++){
                if(nums1[i]!=nums2[i]){
                    return -1;
                }
            }
            return 0;
        }
        int n=nums1.length;
        long sum1=0;
        long sum2=0;
        List<Long> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            sum1+=nums1[i];
            sum2+=nums2[i];
        }
        if(sum1!=sum2){
            return -1;
        }
        for(int i=0;i<n;i++){
            if(nums1[i]==nums2[i]){
                continue;
            }
            long diff=nums2[i]-nums1[i];
            if((diff%k)!=0){
                return -1;
            }
            list.add(diff/k);
        }
        long res=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>0){
                res+=list.get(i);
            }
        }
        return res;
    }
}