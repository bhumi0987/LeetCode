class Solution {
    public long solve(int mid,int[] arr,int[] cost){
        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=1l*Math.abs(mid-arr[i])*cost[i];
        }
        return sum;
    }
    public long minCost(int[] nums, int[] cost) {
        int low=0;
        int high=1000000;
        while(low<=high){
            int mid=(low+high)/2;
            long x=solve(mid-1,nums,cost);
            long y=solve(mid,nums,cost);
            long z=solve(mid+1,nums,cost);
            if(x>=y&&z>=y){
                return y;
            }
            else if(x<y){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return 0;
    }
}