class Solution {
    public int minMoves(int target, int maxDoubles) {
        if(target==0){
            return 1;
        }
        if(target==1){
            return 0;
        }
        if(target==2){
            return 1;
        }
        if(maxDoubles==0){
            return target-1;
        }
        if(target%2==0){
            return 1+minMoves(target/2,maxDoubles-1);
        }else{
            return 1+minMoves((target/2)*2,maxDoubles);
        }
    }
}