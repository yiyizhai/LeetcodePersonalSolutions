public class Solution {
    public int searchInsert(int[] nums, int target) {
         int min = 0;
        int max = nums.length - 1;
        if(max<0) return 0;
        int middle = 0;
        
        int flag = 0;
        while(min<max){
            middle = (max + min)/2;
            flag = compare(target, nums[middle]);
            if(flag == 1){
                min = middle+1;
            }
            else if(flag == -1){
                max = middle-1;
            }
            else
                return middle;
        }
        
        if(min == max){
            middle = min;
            flag = compare(target,nums[middle]);
            if(flag == 1) return middle+1;
            else if(flag == -1) return middle;
            else return middle;
        }
        
        return middle;
    }
     public int compare(int target, int unknown){
        if((target - unknown) > 0)  return 1;
        else if((target - unknown) < 0)  return -1;
        else return 0;
    }
}