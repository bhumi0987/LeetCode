class Solution {
    public int find(int x,int[] parent){
        if(parent[x]==-1){
            return x;
        }
        else{
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }
    public void union(int x,int y,int[] parent){
        int xp=find(x,parent);
        int yp=find(y,parent);
        if(xp!=yp){
            parent[yp]=xp;
        }
        return;
    }
    public int largestComponentSize(int[] nums) {
        int[] parent=new int[100001];
        Arrays.fill(parent,-1);
        for(int i=0;i<nums.length;i++){
            for(int k=2;k<=Math.sqrt(nums[i]);k++){
                if(nums[i]%k==0){
                    union(nums[i],k,parent);
                    union(nums[i],nums[i]/k,parent);
                }
            }
        }
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int x=find(nums[i],parent);
            count=Math.max(count,map.getOrDefault(x,0)+1);
            map.put(x,map.getOrDefault(x,0)+1);
        }
        return count;
    }
}