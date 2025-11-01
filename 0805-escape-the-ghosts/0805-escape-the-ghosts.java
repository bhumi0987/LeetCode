class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int x=Math.abs(target[0]);
        int y=Math.abs(target[1]);
        int sum=x+y;
        int min=Integer.MAX_VALUE;
        for(int[] it:ghosts){
            int a=it[0];
            int b=it[1];
            int k=Math.abs(target[0]-a);
            int z=Math.abs(target[1]-b);
            min=Math.min(min,k+z);
        }
        if(min<=sum){
            return false;
        }
        return true;
    }
}