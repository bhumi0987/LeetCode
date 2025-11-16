class Solution {
    int mod=(int)1e9+7;
    public int numSub(String s) {
        int n=s.length();
        int i=0;
        int j=0;
        int ans=0;
        while(j<n){
            char ch=s.charAt(j);
            if(ch=='1'){
                ans=(ans+j-i+1)%mod;
            }else{
                i=j+1;
            }
            j++;
        }
        return ans;
    }
}