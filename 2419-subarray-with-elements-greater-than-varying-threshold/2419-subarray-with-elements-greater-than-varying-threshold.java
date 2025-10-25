class Solution {
    public int validSubarraySize(int[] a,int threshold){
        int n=a.length;
        Deque<Integer> st=new ArrayDeque<>();      
        int[] next=new int[n];                 
        int[] prev=new int[n];                 
        Arrays.fill(next,-1);
        Arrays.fill(prev,-1);
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&a[i]<a[st.peekLast()]){
                next[st.pollLast()]=i;
            }
            st.addLast(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&a[i]<a[st.peekLast()]){
                prev[st.pollLast()]=i;
            }
            st.addLast(i);
        }
        for(int i=0;i<n;i++){
            int left=prev[i];                          
            int right=next[i]==-1?n:next[i];     
            int len=right-left-1;                 
            if(a[i]>((double)threshold/len)){
                return len;
            }
        }
        return -1;
    }
}
