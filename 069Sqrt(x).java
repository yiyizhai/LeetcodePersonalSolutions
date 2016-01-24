public class Solution {
    public int mySqrt(int x) {
        if(x <= 0){
            return x;
        }
        
        int start = 0, end = x;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(mid == x/mid){
                end = mid;
            }else if(mid < x/mid){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(start != 0 && start == x/start){
            return start;
        }
        else if(end != 0 && end == x/end){
            return end;
        }
        else{
            return start;
        }
    }
}