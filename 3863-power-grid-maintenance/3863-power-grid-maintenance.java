class Solution {
    Map<Integer,TreeSet<Integer>> map=new HashMap<>();
    public void dfs(int node,List<List<Integer>> adj,boolean[] vis,int id,int[] parent){
        vis[node]=true;
        parent[node]=id;
        map.computeIfAbsent(id,k->new TreeSet<>()).add(node);
        for(int it:adj.get(node)){
            if(!vis[it]){
                dfs(it,adj,vis,id,parent);
            }
        }

    }
    public int[] processQueries(int c,int[][] connections,int[][] queries) {
        boolean[] vis=new boolean[c+1];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=c;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:connections){
            int u=it[0];
            int v=it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] parent=new int[c+1];
        for(int i=1;i<=c;i++){
            if(!vis[i]){
                dfs(i,adj,vis,i,parent);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int[] it:queries){
            if(it[0]==1){
                int node=it[1];
                int x=parent[node];
                if(map.containsKey(x)&&map.get(x).contains(node)){
                    ans.add(node);
                }else if(map.containsKey(x)&&!map.get(x).isEmpty()){
                    ans.add(map.get(x).first());
                }else{
                    ans.add(-1);
                }
            }
            else{
                int node=it[1];
                int x=parent[node];
                if(map.containsKey(x)) {
                    map.get(x).remove(node);
                }
            }
        }
        int[] ans1=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ans1[i]=ans.get(i);
        }
        return ans1;
    }
}