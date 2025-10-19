class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int it:nums){
            set.add(it);
        }
        for(int i=k;i<=100000;i+=k){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
}