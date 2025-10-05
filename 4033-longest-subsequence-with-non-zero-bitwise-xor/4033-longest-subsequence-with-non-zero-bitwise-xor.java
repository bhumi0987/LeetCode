class Solution {
    public int longestSubsequence(int[] nums){
        int n=nums.length;
        int xor=0;
        for(int it:nums){
            xor^=it;
        }
        if(xor!=0){
            return n;
        }
        boolean flag=true;
        for(int it:nums){
            if(it!=0){
                flag=false;
                break;
            }
        }
        if(flag){
            return 0;
        }
        return n-1;
    }
}