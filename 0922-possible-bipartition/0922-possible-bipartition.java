class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] color,int idx,int prev){
        color[idx]=prev==1?0:1;
        for(int it:adj.get(idx)){
            if(color[it]==-1){
                if(!dfs(adj,color,it,color[idx])){
                    return false;
                }
            }
            else if(color[idx]==color[it]){
                return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:dislikes){
            int u=it[0];
            int v=it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(!dfs(adj,color,i,1)){
                    return false;
                }
            }
        }
        return true;
    }
}