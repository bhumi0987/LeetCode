class Solution {
    class pair{
        int nums;
        int freq;
        public pair(int nums,int freq){
            this.nums=nums;
            this.freq=freq;
        }
    }
    class compare implements Comparator<pair>{
        public int compare(pair a,pair b){
            return Integer.compare(b.freq,a.freq);
        }
    }
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<pair> pq=new PriorityQueue<>(new compare());
        for(Integer it:map.keySet()){
            pq.add(new pair(it,map.get(it)));
        }
        int ans=0;
        int count=0;
        while(ans*2<arr.length){
            count++;
            pair curr=pq.poll();
            int freq=curr.freq;
            ans+=freq;
        }
        return count;
    }
}