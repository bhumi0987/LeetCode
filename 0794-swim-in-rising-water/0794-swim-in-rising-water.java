class tuple{
    int row;
    int col;
    int cost;
    public tuple(int row,int col,int cost){
        this.row=row;
        this.col=col;
        this.cost=cost;
    }
}
class Solution {
    boolean isvalid(int i,int j,int n){
        return i>=0&&i<n&&j>=0&&j<n;
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        PriorityQueue<tuple> pq=new PriorityQueue<>((a,b) -> {
            return a.cost-b.cost;
        });
        boolean[][] vis=new boolean[n][n];
        pq.add(new tuple(0,0,grid[0][0]));
        int max=Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            tuple temp=pq.poll();
            int row=temp.row;
            int col=temp.col;
            int cost=temp.cost;
            max=Math.max(max,cost);
            if(row==n-1&&col==n-1){
                return max;
            }
            if(vis[row][col]==true){
                continue;
            }
            vis[row][col]=true;
            int[] dr={0,-1,0,1};
		    int[] dc={1,0,-1,0};
            for(int i=0;i<4;i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];
                if(isvalid(nrow,ncol,n)==true&&vis[nrow][ncol]==false){
                    pq.add(new tuple(nrow,ncol,grid[nrow][ncol]));
                }
            }
        }
        return -1;
    }
}