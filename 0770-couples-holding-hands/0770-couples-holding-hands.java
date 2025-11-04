class Solution {
    public int minSwapsCouples(int[] row) {
        int n=row.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(row[i],i);
        }
        int ans=0;
        for(int i=0;i<n-1;i+=2){
            int x=row[i];
            int y;
            if(x%2==0){
                y=x+1;
            }else{
                y=x-1;
            }
            if(row[i+1]!=y){
                ans++;
                int z=map.get(y);
                map.put(row[i+1],z);
                row[z]=row[i+1];
                map.put(y,i+1);
                row[i+1]=y;
            }
        }
        return ans;
    }
}