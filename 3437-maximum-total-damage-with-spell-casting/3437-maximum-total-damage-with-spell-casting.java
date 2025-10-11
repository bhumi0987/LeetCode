class Solution {
    HashMap<Integer,Integer> map;
    long[] dp;
    public long solve(int i,List<Integer> power){
        if(i>=power.size()){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        long notpick=solve(i+1,power);
        long pick=1L*power.get(i)*map.get(power.get(i));
        if(i+1<power.size()&&power.get(i+1)!=power.get(i)+1&&power.get(i+1)!=power.get(i)+2){
            pick+=solve(i+1,power);
        }else if(i+2<power.size()&&power.get(i+2)!=power.get(i)+2){
            pick+=solve(i+2,power);
        }else if(i+3<power.size()){
            pick+=solve(i+3,power);
        }
        return dp[i]=Math.max(pick,notpick);
    }
    public long maximumTotalDamage(int[] power) {
        map=new HashMap<>();
        for(int it:power){
            map.put(it,map.getOrDefault(it,0)+1);
        }
        List<Integer> arr=new ArrayList<>(map.keySet());
        Collections.sort(arr);
        dp=new long[arr.size()];
        Arrays.fill(dp,-1);
        return solve(0,arr);
    }
}