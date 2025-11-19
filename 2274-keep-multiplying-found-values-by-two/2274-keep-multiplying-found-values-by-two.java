class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set=new HashSet<>();
        for(int it:nums){
            set.add(it);
        }
        while(set.contains(original)){
            original*=2;
        }
        return original;
    }
}