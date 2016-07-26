public class Solution {
   public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int last = 0;
        int step = 0;
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > last){
                last = curr;
                step++;
            }
            curr = Math.max(curr, i + nums[i]);
        }
        
        return step;
    }
}
