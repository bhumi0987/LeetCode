class Solution {
    class pair{
        int u;
        int v;
        int w;
        public pair(int u,int v,int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }
    class trip{
        int node;
        int move;
        public trip(int node,int move){
            this.node=node;
            this.move=move;
        }
    }
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        ArrayList<pair>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            int w=it[2];
            adj[u].add(new pair(u,v,w+1));
            adj[v].add(new pair(v,u,w+1));
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<trip> pq=new PriorityQueue<>(Comparator.comparingInt(a->a.move));
        pq.add(new trip(0,0));
        while(!pq.isEmpty()){
            trip curr=pq.poll();
            int node=curr.node;
            int weight=curr.move;
            if(weight>maxMoves){
                continue;
            }
            for(pair it:adj[node]){
                int v=it.v;
                int w=it.w;
                int newdist=weight+w;
                if(newdist<dist[v]&&newdist<=maxMoves){
                    dist[v]=newdist;
                    pq.add(new trip(v,newdist));
                }
            }
        }
        int ans=0;
        for(int it:dist){
            if(it<=maxMoves){
                ans++;
            }
        }
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            int w=it[2];
            int x=Math.max(0,maxMoves-dist[u]);
            int y=Math.max(0,maxMoves-dist[v]);
            ans+=Math.min(w,x+y);
        }
        return ans;
    }
}