class Solution {
    public int maxOperations(String s) {
        int count=0;
        int i=0;
        int n=s.length();
        int ans=0;
        while(i<n){
            if(s.charAt(i)=='1'){
                count++;
                i++;
            }
            else{
                while(i<n&&s.charAt(i)=='0'){
                    i++;
                }
                ans+=count;
            }
        }
        return ans;
    }
}