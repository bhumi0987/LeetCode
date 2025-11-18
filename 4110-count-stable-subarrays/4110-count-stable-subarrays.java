class Solution {
    public long[] countStableSubarrays(int[] nums, int[][] queries) {
        int n=nums.length;
        long[] pre=new long[n];
        int[] right=new int[n];
        int i=0;
        while(i<n){
            int j=i;
            while(j<n&&(i==j||nums[j]>=nums[j-1])){
                pre[j]=j-i+1;
                if(j>i){
                    pre[j]+=pre[j-1];
                }
                j++;
            }
            for(int k=i;k<j;k++){
                right[k]=j;
                if(i>0){
                    pre[k]+=pre[i-1];
                }
            }
            i=j;
        }
        int m=queries.length;
        long[] ans=new long[m];
        for(i=0;i<m;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int j=Math.min(right[l],r+1);
            ans[i]=pre[r]-(j>0?pre[j-1]:0);
            long x=j-l;
            ans[i]+=x*(x+1)/2;
        }
        return ans;
    }
}