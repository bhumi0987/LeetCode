class Solution {
    public int solve(int node,int parent,int[] ans,ArrayList<ArrayList<Integer>> adj,int[] values,int k){
        int sum=values[node];
        for(int it:adj.get(node)){
            if(it!=parent){
                sum+=solve(it,node,ans,adj,values,k);
            }
        }
        if(sum%k==0){
            ans[0]++;
            return 0;
        }
        return sum%k;
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] ans=new int[1];
        solve(0,-1,ans,adj,values,k);
        return ans[0];
    }
}