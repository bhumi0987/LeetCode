class Solution {
    public int maxDistinct(String s) {
        boolean[] freq=new boolean[26];
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(!freq[s.charAt(i)-'a']){
                ans++;
                freq[s.charAt(i)-'a']=true;
            }
        }
        return ans;
    }
}