class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long sum=(long)n*(n+1)/2;
        if(Math.abs(target)>sum||(sum-target)%2!=0){
            return new int[]{};
        }
        long nsum=(sum-target)/2;
        boolean[] vis=new boolean[n+1];
        for(int i=n;i>=1;i--){
            if(nsum>=i){
                nsum-=i;
                vis[i]=true;
            }
        }
        int[] ans=new int[n];
        int idx=0;
        for(int i=n;i>=1;i--){
            if(vis[i]){
                ans[idx++]=-i;
            }
        }
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                ans[idx++]=i;
            }
        }
        return ans;
    }
}