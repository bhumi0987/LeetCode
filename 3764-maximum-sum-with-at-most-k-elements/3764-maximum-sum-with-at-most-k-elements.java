class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        for(int[] it:grid){
            Arrays.sort(it);
        }
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=grid[0].length-1;j>=0&&limits[i]>0;j--){
                arr.add(grid[i][j]);
                limits[i]--;
            }
        }
        Collections.sort(arr);
        long ans=0;
        for(int i=arr.size()-1;i>=0&&k>0;i--){
            ans+=arr.get(i);
            k--;
        }
        return ans;
    }
}