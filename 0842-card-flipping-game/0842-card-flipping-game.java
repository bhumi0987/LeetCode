class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int[] arr=new int[2001];
        for(int i=0;i<fronts.length;i++){
            if(fronts[i]!=backs[i]){
                arr[fronts[i]]++;
                arr[backs[i]]++;
            }else{
                arr[fronts[i]]=arr[fronts[i]]+10000;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0&&arr[i]<10000){
                return i;
            }
        }
        return 0;
    }
}