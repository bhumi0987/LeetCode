class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int target=passingFees.length-1;
        int[] dist=new int[passingFees.length];
        HashMap<Integer,List<int[]>> map=new HashMap<>();
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            int time=it[2];
            map.putIfAbsent(u,new ArrayList<>());
			map.putIfAbsent(v,new ArrayList<>());
			map.get(u).add(new int[]{v,time});
			map.get(v).add(new int[]{u,time});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]==b[1]?a[2]-b[2]:a[1]-b[1]);
        pq.add(new int[]{0,passingFees[0],0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int u=curr[0];
            int cost=curr[1];
            int time=curr[2];
            if(u==target){
                return cost;
            }
            for(int[] it:map.get(u)){
                int v=it[0];
                if((dist[v]==0||time+it[1]<dist[v])&&time+it[1]<=maxTime){
                    pq.add(new int[]{v,cost+passingFees[v],time+it[1]});
                    dist[v]=time+it[1];
                }
            }
        }
        return -1;
    }
}