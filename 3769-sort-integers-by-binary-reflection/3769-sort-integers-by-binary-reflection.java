class Pair{
    int key;
    int val;
    Pair(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class Solution{
    public int[] sortByReflection(int[] nums){
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->a.key!=b.key?a.key-b.key:a.val-b.val
        );
        for(int val:nums){
            String bin=Integer.toBinaryString(val);
            StringBuilder sb=new StringBuilder(bin); 
            sb.reverse();
            String rev=sb.toString();
            int num=Integer.parseInt(rev,2);
            pq.add(new Pair(num, val));
        }
        int arr[]=new int[nums.length];
        int i=0;
        while(!pq.isEmpty()){
            arr[i++]=pq.poll().val;
        }
        return arr;
    }   
}