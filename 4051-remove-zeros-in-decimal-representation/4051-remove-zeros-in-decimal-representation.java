class Solution {
    public long removeZeros(long n) {
        long ans=0;
        while(n>0){
            long x=n%10;
            if(x!=0){
                ans=ans*10+x;
            }
            n/=10;
        }
        long res=0;
        while(ans>0){
            long x=ans%10;
            res=res*10+x;
            ans/=10;
        }
        return res;
    }
}