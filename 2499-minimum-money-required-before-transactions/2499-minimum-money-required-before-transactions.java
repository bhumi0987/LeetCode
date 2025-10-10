class Solution {
    public long minimumMoney(int[][] transactions) {
        long spend=0;
        long cost=0;
        long ans=0;
        for(int[] it:transactions){
            if(it[0]>it[1]){
                spend+=it[0]-it[1];
                ans=Math.max(ans,it[1]);
            }else{
                cost=Math.max(cost,it[0]);
            }
        }
        return spend+Math.max(cost,ans);
    }
}