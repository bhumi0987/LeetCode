class Solution {
    public int minSensors(int n, int m, int k) {
        int s=2*k+1;
        return (int)Math.ceil((n+s-1)/s)*(int)Math.ceil((m+s-1)/s);
    }
}