class Solution {
    static class UnionFind {
        private final int[] parent;
        private final int[] rank;
        private int count;
        UnionFind(int n){
            count=n;
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }
        private int root(int p){
            while(parent[p]!=p){
                parent[p]=parent[parent[p]];
                p=parent[p];
            }
            return p;
        }
        public int count(){
            return count;
        }

        public boolean find(int p,int q){
            return root(p)==root(q);
        }
        public boolean union(int p,int q){
            int rootP=root(p);
            int rootQ=root(q);
            if(rootP==rootQ){
                return false;
            }
            if(rank[rootP]<rank[rootQ]){
                parent[rootP]=rootQ;
                rank[rootQ]+=rank[rootP];
            }else{
                parent[rootQ]=rootP;
                rank[rootP]+=rank[rootQ];
            }
            count--;
            return true;
        }
    }
    public boolean solve(int n,int t,int[][] edges,int k){
        UnionFind uf=new UnionFind(n);
        for(int[] it:edges){
            if(it[2]>t){
                uf.union(it[0],it[1]);
            }
        }
        return uf.count>=k;
    }
    public int minTime(int n, int[][] edges, int k) {
        int high=0;
        for(int[] it:edges){
            high=Math.max(high,it[2]);
        }
        int low=0;
        while(low<high){
            int mid=(high-low)/2+low;
            if(solve(n,mid,edges,k)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}