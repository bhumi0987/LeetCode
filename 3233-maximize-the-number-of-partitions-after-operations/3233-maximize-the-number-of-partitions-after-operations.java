class Solution {
    Map<String,Integer> map;
    public int maxPartitionsAfterOperations(String s, int k) {
        map=new HashMap<>();
        return 1+dfs(s,0,true,0,k);
    }
    public int dfs(String s,int idx,boolean canChange,int mask,int k){
        int n=s.length();
        if(idx==n)return 0;
        int bit = 1<<(s.charAt(idx)-'a');
        String key=idx+"_"+canChange+"_"+mask;
        if(map.containsKey(key))return map.get(key);
        int res=helper(s,idx,canChange,mask,bit,k);
        if(canChange){
            for(int c=0;c<26;c++){
                int newBit=1<<c;
                res=Math.max(res,helper(s,idx,false,mask,newBit,k));
            }
        }
        map.put(key,res);
        return res;
    }
    public int helper(String s,int i,boolean canChange,int mask,int newBit,int k){
        int n=s.length();
        int newMask=mask|newBit;
        if(Integer.bitCount(newMask)>k){
            return 1+dfs(s,i+1,canChange,newBit,k);
        }
        else return dfs(s,i+1,canChange,newMask,k);
    }
}