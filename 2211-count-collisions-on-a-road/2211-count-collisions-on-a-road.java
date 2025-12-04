class Solution {
    public int countCollisions(String s) {
        int ans=0;
        Stack<Character> st=new Stack<>();
        st.push(s.charAt(0));
        int n=s.length();
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            if(st.peek()=='R'&&ch=='L'){
                ans+=2;
                st.pop();
                ch='S';
            }else if(st.peek()=='S'&&ch=='L'){
                ch='S';
                ans+=1;
            }
            while(!st.isEmpty()&&(st.peek()=='R'&&ch=='S')){
                ans+=1;
                st.pop();
            }
            st.push(ch);
        }
        return ans;
    }
}