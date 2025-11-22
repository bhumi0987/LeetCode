class Solution {
    public int solve(int n) {
        String s=Integer.toString(n);
        int len=s.length();
        if(len<0){
            return 0;
        }
        int ans=0;
        for(int i=1;i<len-1;i++){
            int a=s.charAt(i-1)-'0';
            int b=s.charAt(i)-'0';
            int c=s.charAt(i+1)-'0';
            if(b>a&&b>c){
                ans++;
            }
            else if(b<a&&b<c){
                ans++;
            }
        }
        return ans;
    }
    public int totalWaviness(int num1, int num2) {
        int ans=0; 
        for(int i=num1;i<=num2;i++){
            ans+=solve(i);
        }
        return ans;
    }
}