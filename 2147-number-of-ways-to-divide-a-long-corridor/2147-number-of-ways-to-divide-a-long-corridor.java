class Solution {
    public static int mod=1_000_000_007;
    public int solve(int i,int seat,String corridor,Map<Pair<Integer,Integer>,Integer> dp){
        if(i==corridor.length()){
            return seat==2?1:0;
        }
        if(dp.containsKey(new Pair<>(i,seat))){
            return dp.get(new Pair<>(i,seat));
        }
        int ans=0;
        if(seat==2){
            if(corridor.charAt(i)=='S'){
                ans=solve(i+1,1,corridor,dp);
            }else{
                ans=(solve(i+1,0,corridor,dp)+solve(i+1,2,corridor,dp))%mod;
            }
        }else{
            if(corridor.charAt(i)=='S'){
                ans=solve(i+1,seat+1,corridor,dp);
            }else{
                ans=solve(i+1,seat,corridor,dp);
            }
        }
        dp.put(new Pair<>(i,seat),ans);
        return ans;
    }
    public int numberOfWays(String corridor) {
        Map<Pair<Integer,Integer>,Integer> dp=new HashMap<>();
        return solve(0,0,corridor,dp);
    }
}