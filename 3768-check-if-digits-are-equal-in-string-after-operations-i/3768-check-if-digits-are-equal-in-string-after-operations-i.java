class Solution {
    public String solve(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<s.length();i++){
            int a=Character.getNumericValue(s.charAt(i-1));
            int b=Character.getNumericValue(s.charAt(i));
            int sum=(a+b)%10;
            sb.append(sum);
        }
        return sb.toString();
    }
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
            s=solve(s);
        }
        if(s.charAt(0)==s.charAt(1)){
            return true;
        }
        return false;
    }
}