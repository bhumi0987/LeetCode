class Solution {
    public int minSwaps(String s) {
        int zero=0;
        int one=0;
        int miss0=0;
        int miss1=0;
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                one++;
            }else{
                zero++;
            }
        }
        if(Math.abs(zero-one)>1){
            return -1;
        }
        for(int i=0;i<s.length();i+=2){
            if(s.charAt(i)!='0'){
                miss0++;
            }
            else{
                miss1++;
            }
        }
        return zero==one?Math.min(miss0,miss1):zero>one?miss0:miss1;
    }
}