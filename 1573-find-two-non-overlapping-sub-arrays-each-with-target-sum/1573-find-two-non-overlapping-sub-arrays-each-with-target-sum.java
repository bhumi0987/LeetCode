class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        long[] dp=new long[arr.length];
        long[] mini=new long[arr.length];
        long ans=Integer.MAX_VALUE;
        Arrays.fill(dp,Integer.MAX_VALUE);
        Arrays.fill(mini,Integer.MAX_VALUE);
        int start=0;
        int end=0;
        int sum=0;
        while(end<arr.length){
            sum+=arr[end];
            while(target<sum&&start<end){
                sum-=arr[start];
                start++;
            }
            if(target==sum){
                dp[end]=end-start+1;
            }
            end++;
        }
        long min=Integer.MAX_VALUE;
        for(int i=0;i<dp.length;i++){
            min=Math.min(min,dp[i]);
            mini[i]=min;
        }
        for(int i=0;i<dp.length;i++){
            if(dp[i]==Integer.MAX_VALUE){
                continue;
            }
            ans=Math.min(ans,(i-dp[i]<0?Integer.MAX_VALUE:mini[(int)(i-dp[i])]+dp[i]));
        }
        if(ans>=Integer.MAX_VALUE){
            return -1;
        }
        return (int)ans;
    }
}