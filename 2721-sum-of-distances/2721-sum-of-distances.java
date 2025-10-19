class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        long[] ans=new long[n];
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        for(ArrayList<Integer> it:map.values()){
            int size=it.size();
            if(size==0){
                continue;
            }
            long sum=0;
            for(int it1:it){
                sum+=it1;
            }
            long pre=0;
            for(int i=0;i<size;i++){
                int idx=it.get(i);
                long left=i;
                long right=size-i-1;
                long lsum=pre;
                long rsum=sum-pre-idx;
                ans[idx]=(idx*left-lsum)+(rsum-idx*right);
                pre+=idx;
            }
        }
        return ans;
    }
}