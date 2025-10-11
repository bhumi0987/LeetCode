class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        int[] diff=new int[n];
        for(int i=0;i<n;i++){
            diff[i]=capacity[i]-rocks[i];
        }
        int ans=0;
        Arrays.sort(diff);
        for(int i=0;i<n;i++){
            if(diff[i]==0){
                ans++;
            }else if(diff[i]<=additionalRocks){
                additionalRocks-=diff[i];
                ans++;
            }
        }
        return ans;
    }
}