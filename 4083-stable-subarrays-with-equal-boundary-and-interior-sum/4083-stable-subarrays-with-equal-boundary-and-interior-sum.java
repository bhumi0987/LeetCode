class Solution {
    public long countStableSubarrays(int[] capacity) {
        int n=capacity.length;
        int[] pre=new int[n];
        pre[0]=capacity[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+capacity[i];
        }
        HashMap<String,Integer> map=new HashMap<>();
        long ans=0;
        for(int i=n-1;i>=0;i--){
            long ans1=pre[i]+2*capacity[i];
            String key=ans1+"+"+capacity[i];
            ans+=map.getOrDefault(key,0);
            String curr=pre[i]+"+"+capacity[i];
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        for(int i=0;i<n-1;i++){
            if(capacity[i]==capacity[i+1]&&capacity[i]==0){
                ans--;
            }
        } 
        return ans;
    }
}