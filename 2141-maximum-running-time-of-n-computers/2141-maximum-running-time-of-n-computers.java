class Solution {
    public boolean solve(int n,int[] batteries,long mid){
        long ans=0;
        for(int it:batteries){
            ans+=Math.min(it,mid);
        }
        return ans>=mid*n;
    }
    public long maxRunTime(int n, int[] batteries) {
        long low=1;
        long high=0;
        for(int it:batteries){
            high+=it;
        }
        while(low<=high){
            long mid=low+(high-low)/2;
            if(solve(n,batteries,mid)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }
}