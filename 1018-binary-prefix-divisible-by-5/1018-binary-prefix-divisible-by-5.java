class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans=new ArrayList<>();
        int count=0;
        for(int it:nums){
            count=((count*2)+it)%5;
            ans.add(count==0);
        }
        return  ans;
    }
}