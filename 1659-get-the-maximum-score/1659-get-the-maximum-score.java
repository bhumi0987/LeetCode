class Solution {
    int mod=(int)1e9+7;
    public long solve(int idx,int path,Map<Integer,Integer> path1,Map<Integer,Integer> path2,int[] nums1,int[] nums2,long[][] dp){
        if(path==1){
            if(idx>=nums1.length){
                return 0;
            }
        }else if(path==2){
            if(idx>=nums2.length){
                return 0;
            }
        }
        if(dp[idx][path]!=-1){
            return dp[idx][path];
        }
        if(path==1){
            long op1=nums1[idx]+solve(idx+1,1,path1,path2,nums1,nums2,dp);
            long op2=0;
            if(path2.containsKey(nums1[idx])){
                op2=nums1[idx]+solve(path2.get(nums1[idx])+1,2,path1,path2,nums1,nums2,dp);
            }
            return dp[idx][path]=Math.max(op1,op2);
        }else{
            long op1=nums2[idx]+solve(idx+1,2,path1,path2,nums1,nums2,dp);
            long op2=0;
            if(path1.containsKey(nums2[idx])){
                op2=nums2[idx]+solve(path1.get(nums2[idx])+1,1,path1,path2,nums1,nums2,dp);
            }
            return dp[idx][path]=Math.max(op1,op2);
        }
    }
    public int maxSum(int[] nums1, int[] nums2) {
        Map<Integer,Integer> path1=new HashMap<>();
        Map<Integer,Integer> path2=new HashMap<>();
        int n=Math.max(nums1.length,nums2.length);
        long[][] dp=new long[n][3];
        for(long[] it:dp){
            Arrays.fill(it,-1);
        }
        for(int i=0;i<nums1.length;i++){
            path1.put(nums1[i],i);
        }
        for(int i=0;i<nums2.length;i++){
            path2.put(nums2[i],i);
        }
        long res1=solve(0,1,path1,path2,nums1,nums2,dp)%mod;
        long res2=solve(0,2,path1,path2,nums1,nums2,dp)%mod;
        return (int)Math.max(res1,res2)%mod;
    }
}