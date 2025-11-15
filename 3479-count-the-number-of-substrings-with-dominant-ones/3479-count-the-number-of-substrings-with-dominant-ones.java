class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int[] pre=new int[n];
        pre[0]=((int)(s.charAt(0)-'0'))==1?1:0;
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+(((int)(s.charAt(i)-'0'))==1?1:0);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int one=pre[j]-(i==0?0:pre[i-1]);
                int zero=(j-i+1)-one;
                if((zero*zero)>one){
                    j+=(zero*zero-one-1);
                }else{
                    ans++;
                    int diff=(int)Math.sqrt(one)-zero;
                    int nextj=j+diff;
                    if(nextj>=n){
                        ans+=(n-j-1);
                        j=n;
                    }else{
                        ans+=diff;
                        j=nextj;
                    }
                }
            }
        }
        return ans;
    }
}