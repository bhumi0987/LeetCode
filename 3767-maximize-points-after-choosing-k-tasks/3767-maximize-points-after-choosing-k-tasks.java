class Solution {
    public long maxPoints(int[] a,int[] b,int k){
        int n=a.length;
        int[][] arr=new int [n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=a[i];
            arr[i][1]=b[i];
        }
        Arrays.sort(arr,(x,y)->Integer.compare(y[0]-y[1],x[0]-x[1]));
        long ans=0;
        for(int i=0;i<k;i++){
            ans=ans+arr[i][0];
        }
        for(int i=k;i<n;i++){
            ans=ans+Math.max(arr[i][1],arr[i][0]);
        }
        return ans;
    }
}