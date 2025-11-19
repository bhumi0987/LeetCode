class Solution {
    public int[] prevPermOpt1(int[] arr) {
        for(int i=arr.length-2;i>=0;i--){
            int max=Integer.MIN_VALUE;
            int idx=-1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]&&arr[j]>max){
                    max=Math.max(max,arr[j]);
                    idx=j;
                }
            }
            if(max!=Integer.MIN_VALUE){
                int temp=arr[i];
                arr[i]=max;
                arr[idx]=temp;
                return arr;
            }
        }
        return arr;
    }
}