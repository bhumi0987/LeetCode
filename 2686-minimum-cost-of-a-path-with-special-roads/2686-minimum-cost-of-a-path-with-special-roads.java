class Solution {
    class pair{
        int x;
        int y;
        int cost;
        pair(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int n=specialRoads.length;
        int m=specialRoads[0].length;
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        int fx=target[0];
        int fy=target[1];
        int sx=start[0];
        int sy=start[1];
        pq.add(new pair(sx,sy,0));
        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int x=curr.x;
            int y=curr.y;
            if(map.containsKey(x)&&map.get(x).contains(y)){
                continue;
            }
            if(!map.containsKey(x)){
                map.put(x,new HashSet<Integer>());
            }
            map.get(x).add(y);
            if(x==fx&&y==fy){
                return curr.cost;
            }
            pq.add(new pair(fx,fy,curr.cost+Math.abs(x-fx)+Math.abs(y-fy)));
            for(int i=0;i<n;i++){
                int x1=specialRoads[i][0];
                int y1=specialRoads[i][1];
                int x2=specialRoads[i][2];
                int y2=specialRoads[i][3];
                int cost=specialRoads[i][4];
                if(map.containsKey(x2)&&map.get(x2).contains(y2)){
                    continue;
                }
                pq.add(new pair(x2,y2,curr.cost+cost+Math.abs(x-x1)+Math.abs(y-y1)));
            }
        }
        return -1;
    }
}