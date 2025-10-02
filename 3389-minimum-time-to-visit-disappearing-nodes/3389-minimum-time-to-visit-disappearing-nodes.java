class pair{
    int node;
    int dist;
    pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int dist=edges[i][2];
            adj.get(u).add(new pair(v,dist));
            adj.get(v).add(new pair(u,dist));
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            pair temp=pq.poll();
            int node=temp.node;
            int dist=temp.dist;
            if(dist>ans[node]||dist>=disappear[node]){
                continue;
            }
            for(pair it:adj.get(node)){
                int newnode=it.node;
                int newdist=it.dist;
                if(dist+newdist<ans[newnode]&&dist+newdist<disappear[newnode]){
                    ans[newnode]=dist+newdist;
                    pq.add(new pair(newnode,dist+newdist));
                }
            }
        }
        for(int i=0;i<n;i++){
            if(ans[i]==Integer.MAX_VALUE){
                ans[i]=-1;
            }
        }
        return ans;
    }
}