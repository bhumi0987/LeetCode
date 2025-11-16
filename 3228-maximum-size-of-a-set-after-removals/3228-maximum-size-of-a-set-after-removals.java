class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> set1=new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        for(int num:nums2){
            set1.add(num);
        }
        int common=0;
        int m1=set.size();
        int m2=set1.size();
        int n=nums1.length;
        for(int num:set){
            if(set1.contains(num)){
                common++;
            }
        }
        int uniq1=m1-common;
        int uniq2=m2-common;
        if(uniq1>=n/2&&uniq2>=n/2){
            return n;
        }
        if(uniq1<n/2&&uniq2<n/2){
            return Math.min(n,uniq1+uniq2+common);
        }
        if(uniq1<n/2){
            return Math.min(n/2,uniq1+common)+n/2;
        }
        return Math.min(n/2,uniq2+common)+n/2;
    }
}