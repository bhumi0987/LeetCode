class Solution {
    public int largestPrime(int n){
        boolean[] prime=new boolean[n+1];
        for(int i=0;i<=n;i++){
            prime[i]=true;
        }
        for(int p=2;p*p<=n;p++){
            if(prime[p]){
                for(int i=p*p;i<=n;i+=p){
                    prime[i] = false;
                }
            }
        }
        int sum=0;
        int max=0;
        int count=0;
        for(int i=2;i<=n;i++){
            if(prime[i]&&sum+i<=n){
                sum+=i;
                if(prime[sum]){
                    max=Math.max(max,sum);
                }
            }else if(sum>=n){
                break;
            }
        }
        return max;
    }
}