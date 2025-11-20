class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[1]!=b[1]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(b[0],a[0]);
        });
        int a=-1;
        int b=-1;
        int ans=0;
        for(int[] it:intervals){
            int l=it[0];
            int r=it[1];
            if(l>b){
                ans+=2;
                a=r-1;
                b=r;
            }else if(l>a){
                ans++;
                a=b;
                b=r;
            }
        }
        return ans;
    }
}