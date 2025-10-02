class Solution {
    public long numberOfSubarrays(int[] nums) {
        long ans=0;
        Stack<int[]> st=new Stack<>();
        st.push(new int[]{Integer.MAX_VALUE,0});
        for(int it:nums){
            while(st.peek()[0]<it){
                st.pop();
            }
            if(st.peek()[0]!=it){
                st.push(new int[]{it,0});
            }
            ans+=++st.peek()[1];
        }
        return ans;
    }
}