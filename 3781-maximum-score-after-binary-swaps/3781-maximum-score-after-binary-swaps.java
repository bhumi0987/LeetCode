class Solution {
    public long maximumScore(int[] nums, String s) {
        int n=nums.length;
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                arr.add(i);
            }
        }
        if(arr.size()==0){
            return 0;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int idx=0;
        long ans=0;
        for(int i=0;i<n;i++){
            pq.add(nums[i]);
            if(i==arr.get(idx)){
                ans+=pq.poll();
                idx++;
            }
            if(idx==arr.size()){
                break;
            }
        }
        return ans;
    }
}