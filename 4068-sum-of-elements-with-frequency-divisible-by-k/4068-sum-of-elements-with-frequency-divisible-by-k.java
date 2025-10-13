class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int max=0;
        for(int it:nums){
            max=Math.max(max,it);
        }
        int[] freq=new int[max+1];
        for(int it:nums){
            freq[it]++;
        }
        int sum=0;
        for(int i=0;i<=max;i++){
            if(freq[i]%k==0){
                sum+=i*freq[i];
            }
        }
        return sum;
    }
}