class Solution {
    public String removeSubstring(String s, int k) {
        StringBuilder sb=new StringBuilder();
        int open=0;
        for(char ch:s.toCharArray()){
            sb.append(ch);
            if(ch=='('){
                open++;
            }else{
                if(sb.length()>=2*k&&open>=k){
                    int len=sb.length();
                    boolean valid=true;
                    for(int i=len-2*k;i<len-k;i++){
                        if(sb.charAt(i)!='('){
                            valid=false;
                            break;
                        }
                    }
                    for(int i=len-k;i<len;i++){
                        if(sb.charAt(i)!=')'){
                            valid=false;
                            break;
                        }
                    }
                    if(valid){
                        sb.setLength(sb.length()-2*k);
                        open-=k;
                    }
                }
            }
        }
        return sb.toString();
    }
}