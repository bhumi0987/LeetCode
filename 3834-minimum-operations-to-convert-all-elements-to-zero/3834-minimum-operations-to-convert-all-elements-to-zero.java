class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int ans=0;
        for(int it:nums){
            while(!st.isEmpty()&&st.peek()>it){
                st.pop();
            }
            if(st.isEmpty()||st.peek()<it){
                ans++;
                st.push(it);
            }
        }
        return ans;
    }
}