class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer,TreeSet<Integer>> x=new HashMap<>();
        Map<Integer,TreeSet<Integer>> y=new HashMap<>();
        for(int[] it:buildings){
            int x1=it[0];
            int y1=it[1];
            x.computeIfAbsent(x1,k->new TreeSet<>()).add(y1);
            y.computeIfAbsent(y1,k->new TreeSet<>()).add(x1);
        }
        int ans=0;
        for(int[] it:buildings){
            int x1=it[0];
            int y1=it[1];
            TreeSet<Integer> cols=x.get(x1);
            TreeSet<Integer> rows=y.get(y1);
            Integer left=cols.lower(y1);
            Integer right=cols.higher(y1);
            Integer up=rows.lower(x1);
            Integer down=rows.higher(x1);
            if((left!= null)&&(right!=null)&&(up!=null)&&(down!=null)){
                ans++;
            }
        }
        return ans;
    }
}