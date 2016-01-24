public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int[] numst = new int[len];
        int cnt = 0;
        
        for(int i = 0; i < len; i++){
            if(nums[i]!=val){
                numst[cnt++] = nums[i]; 
            }
        }
        
        for(int i = 0; i<cnt; i++){
            nums[i] = numst[i];
        }
        return cnt;
        
    }
}