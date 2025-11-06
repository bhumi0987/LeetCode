class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int it:nums){
            map.put(it,map.getOrDefault(it,0)+1);
        }
        for(int it:nums){
            if(map.getOrDefault(it,0)==1&&!map.containsKey(it-1)&&!map.containsKey(it+1)){
                ans.add(it);
            }
        }
        return ans;
    }
}