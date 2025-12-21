class Solution {
    public int mirrorDistance(int n) {
        int rev=n;
        int rev1=0;
        while(rev>0){
            int x=rev%10;
            rev1=rev1*10+x;
            rev/=10;
        }
        return Math.abs(n-rev1);
    }
}