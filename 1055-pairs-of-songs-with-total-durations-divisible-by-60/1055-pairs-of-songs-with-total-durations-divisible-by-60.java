class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] freq=new int[60];
        for(int it:time){
            freq[it%60]++;
        }
        long count=0;
        count+=(long)freq[0]*(freq[0]-1)/2;
        count+=(long)freq[30]*(freq[30]-1)/2;
        for(int i=1;i<30;i++){
            count+=(long)freq[i]*freq[60-i];
        }
        return (int)count;
    }
}