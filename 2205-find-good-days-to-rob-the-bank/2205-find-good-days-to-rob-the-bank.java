class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n=security.length;
        int[] pre=new int[n];
        int[] suff=new int[n];
        pre[0]=0;
        for(int i=1;i<n;i++){
            if(security[i-1]>=security[i]){
                pre[i]=pre[i-1]+1;
            }
        }
        suff[n-1]=0;
        for(int i=n-2;i>=0;i--){
            if(security[i]<=security[i+1]){
                suff[i]=suff[i+1]+1;
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(pre[i]>=time&&suff[i]>=time){
                ans.add(i);
            }
        }
        return ans;
    }
}