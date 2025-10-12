class Solution {
    public boolean solve1(ArrayList<Integer>[] graph,int[] color,int node,int c){
        color[node]=c;
        for(int it:graph[node]){
            if(color[it]==-1){
                if(!solve1(graph,color,it,1-c)){
                    return false;
                }
            }else if(color[node]==color[it]){
                return false;
            }
        }
        return true;
    }
    public boolean solve(int[][] points,long mid){
        int n=points.length;
        ArrayList<Integer>[] graph=new ArrayList[n];
        Arrays.setAll(graph,o->new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int[] x=points[i];
                int[] y=points[j];
                if((Math.abs(x[0]-y[0])+Math.abs(x[1]-y[1]))<mid){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1&&!solve1(graph,color,i,0)){
                return false;
            }
        }
        return true;
    }
    public int maxPartitionFactor(int[][] points) {
        int n=points.length;
        long max=0;
        if(n<=2){
            return 0;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int[] x=points[i];
                int[] y=points[j];
                max=Math.max(max,Math.abs(x[0]-y[0])+Math.abs(x[1]-y[1]));
            }
        }
        long low=0;
        long high=max;
        while(low<=high){
            long mid=(low+high)>>1;
            if(solve(points,mid)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return (int)high;
    }
}