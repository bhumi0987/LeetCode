class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int count=0;
        for(int i=0;i<n;i++){
            int x=arr[i];
            while(!st.isEmpty()&&arr[i]<st.peek()){
                x=Math.max(x,st.pop());
            }
            st.push(x);
        }
        return st.size();
    }
}