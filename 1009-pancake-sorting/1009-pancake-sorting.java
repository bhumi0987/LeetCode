class Solution {
    public int solve(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    public void solve1(int[] arr,int idx){
        int start=0;
        while(start<idx){
            int temp=arr[start];
            arr[start]=arr[idx];
            arr[idx]=temp;
            start++;
            idx--;
        }
    }
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans=new ArrayList<>();
        int end=arr.length;
        while(end!=1){
            int idx=solve(arr,end);
            solve1(arr,idx);
            solve1(arr,end-1);
            ans.add(idx+1);
            ans.add(end);
            end--;
        } 
        return ans;
    }
}