class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> set=new HashSet<>();
        for(Character c:s.toCharArray()){
            set.add(c);
        }
        int ans=0;
        for(Character letter:set){
            int i=-1;
            int j=0;
            for(int k=0;k<s.length();k++){
                if(s.charAt(k)==letter){
                    if(i==-1){
                        i=k;
                    }
                    j=k;
                }
            }
            Set<Character> set1=new HashSet<>();
            for(int k=i+1;k<j;k++){
                set1.add(s.charAt(k));
            }
            ans+=set1.size();
        }
        return ans;
    }
}