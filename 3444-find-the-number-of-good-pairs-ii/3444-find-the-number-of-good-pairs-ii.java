class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int it:nums2){
            map.put(it*k,map.getOrDefault(it*k,0)+1);
        }
        long ans=0;
        for(int it:nums1){
            for(int i=1;i<=Math.sqrt(it);i++){
                if(it%i==0){
                    int x=it/i;
                    if(map.containsKey(i)){
                        ans+=map.get(i);
                    }
                    if(x!=i&&map.containsKey(x)){
                        ans+=map.get(x);
                    }
                }
            }
        }
        return ans;
    }
}