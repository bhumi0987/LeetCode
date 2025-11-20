class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int n=elements.length;
        int m=groups.length;
        int max=Arrays.stream(groups).max().orElse(-1);;
        int[] dist=new int[max+1];
        Arrays.fill(dist,-1);
        for(int i=0;i<n;i++){
            int x=elements[i];
            if(x>max||dist[x]>=0){
                continue;
            }
            for(int j=x;j<=max;j+=x){
                if(dist[j]<0){
                    dist[j]=i;
                }
            }
        }
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            ans[i]=dist[groups[i]];
        }
        return ans;
    }
}