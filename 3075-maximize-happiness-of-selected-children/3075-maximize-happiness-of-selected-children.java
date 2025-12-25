class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<happiness.length;i++){
            pq.add(happiness[i]);
        }
        long count=0;
        long sum=0;
        while(k>0&&!pq.isEmpty()){
            sum+=(long)pq.peek()-count>0?(long)pq.poll()-count:0;
            count++;
            k--;
        }
        return sum;
    }
}