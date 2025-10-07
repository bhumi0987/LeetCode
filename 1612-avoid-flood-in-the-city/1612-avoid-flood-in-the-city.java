class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans=new int[rains.length];
        Arrays.fill(ans,-1);
        Map<Integer,Integer> map=new HashMap<>();
        TreeSet<Integer> dry=new TreeSet<>();
        for(int i=0;i<rains.length;i++){
            if(rains[i]==0){
                dry.add(i);
            }
            else{
                if(map.containsKey(rains[i])){
                    Integer nextdry=dry.ceiling(map.get(rains[i]));
                    if(nextdry==null){
                        return new int[0];
                    }
                    ans[nextdry]=rains[i];
                    dry.remove(nextdry);
                }
                map.put(rains[i],i);
            }
        }
        for(int i:dry){
            ans[i]=1;
        }
        return ans;
    }
}