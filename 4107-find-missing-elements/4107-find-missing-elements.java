class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        HashSet<Integer> set=new HashSet<>();
        for(int it:nums){
            max=Math.max(max,it);
            min=Math.min(min,it);
            set.add(it);
        }
        for(int i=min;i<=max;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}