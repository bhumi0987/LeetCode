class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq=new int[value];
        for(int it:nums){
            int rem=((it%value)+value)%value;
            freq[rem]++;
        }
        int count=0;
        while(freq[count%value]>0){
            freq[count%value]--;
            count++;
        }
        return count;
    }
}