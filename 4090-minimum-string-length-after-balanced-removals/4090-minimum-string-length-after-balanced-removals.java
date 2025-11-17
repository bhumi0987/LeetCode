class Solution {
    public int minLengthAfterRemovals(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!st.isEmpty()&&((st.peek()=='a'&&ch=='b')||(st.peek()=='b'&&ch=='a'))){
                st.pop();
            }else{
                st.push(ch);
            }
        } 
        return st.size();
    }
}