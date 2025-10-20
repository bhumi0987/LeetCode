class Solution {
    public boolean solve(int[] freq,String t,int i,char[] ans,boolean flag){
        if(i==ans.length){
            String res=new String(ans);
            if(res.compareTo(t)>0){
                return true;
            }
            return false;
        }
        char ch=flag?'a':t.charAt(i);
        for(;ch<='z';ch++){
            if(freq[ch-'a']==0){
                continue;
            }
            if(ch>t.charAt(i)){
                flag=true;
            }
            ans[i]=ch;
            freq[ch-'a']--;
            if(solve(freq,t,i+1,ans,flag)){
                return true;
            }
            ans[i]=' ';
            freq[ch-'a']++;
        }
        return false;
    }
    public String lexGreaterPermutation(String s, String t) {
        int n=s.length();
        if(n==1){
            if(s.charAt(0)<=t.charAt(0)){
                return "";
            }
            return s;
        }
        int[] freq=new int[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        char[] ans=new char[n];
        solve(freq,t,0,ans,false);
        return (new String(ans)).trim();
    }
}