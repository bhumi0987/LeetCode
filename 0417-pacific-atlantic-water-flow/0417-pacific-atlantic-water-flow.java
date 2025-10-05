class Solution {
    int n;
    int m;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(int i,int j,int[][] heights,boolean[][] vis){
        if(vis[i][j]){
            return;
        }
        vis[i][j]=true;
        for(int[] it:dir){
            int nrow=i+it[0];
            int ncol=j+it[1];
            if(nrow<0||nrow>=n||ncol<0||ncol>=m){
                continue;
            }
            if(heights[nrow][ncol]<heights[i][j]){
                continue;
            }
            dfs(nrow,ncol,heights,vis);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n=heights.length;
        m=heights[0].length;
        boolean[][] vis=new boolean[n][m];
        boolean[][] vis1=new boolean[n][m];
        for(int i=0;i<n;i++){
            dfs(i,0,heights,vis);
        }
        for(int i=0;i<m;i++){
            dfs(0,i,heights,vis);
        }
        for(int i=0;i<n;i++){
            dfs(i,m-1,heights,vis1);
        }
        for(int i=0;i<m;i++){
            dfs(n-1,i,heights,vis1);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]&&vis1[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}