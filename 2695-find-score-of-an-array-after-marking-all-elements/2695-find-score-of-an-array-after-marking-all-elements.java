class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i],i});
        }
        long ans=0;
        boolean[] vis=new boolean[nums.length];
        Arrays.fill(vis,false);
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int i=curr[1];
            if(vis[i]==false){
                ans+=nums[i];
                vis[i]=true;
                if(i-1>=0){
                    vis[i-1]=true;
                } 
                if(i+1<nums.length){
                    vis[i+1]=true;
                }
            }
        }
        return ans;
    }
}