class Solution {
    public void dfs1(int node,int parent,Map<Integer,List<int[]>> adj,int[] dp){
        for(int[] it:adj.get(node)){
            int v=it[0];
            int w=it[1];
            if(v==parent){
                continue;
            }
            dp[v]=dp[node];
            if(w==1){
                dp[v]--;
            }else{
                dp[v]++;
            }
            dfs1(v,node,adj,dp);
        }
    }
    public int dfs(int node,int parent,Map<Integer,List<int[]>> adj){
        int ans=0;
        for(int[] it:adj.get(node)){
            int v=it[0];
            int w=it[1];
            if(v==parent){
                continue;
            }
            ans+=dfs(v,node,adj)+w;
        }
        return ans;
    }
    public int[] minEdgeReversals(int n, int[][] edges) {
        Map<Integer,List<int[]>> adj=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] it:edges){
            adj.get(it[0]).add(new int[]{it[1],0});
            adj.get(it[1]).add(new int[]{it[0],1});
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=dfs(0,-1,adj);
        dfs1(0,-1,adj,dp);
        return dp;
    }
}