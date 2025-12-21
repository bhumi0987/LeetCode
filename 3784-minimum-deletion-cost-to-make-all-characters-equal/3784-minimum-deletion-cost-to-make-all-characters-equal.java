class Solution {
    public long minCost(String s, int[] cost) {
        long[] freq=new long[26];
        long max=0;
        long ans=0;
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';
            freq[c]+=cost[i];
            max=Math.max(freq[c],max);
            ans+=cost[i];
        }
        return ans-max;
    }
}