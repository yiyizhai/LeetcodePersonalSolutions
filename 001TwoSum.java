public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int[] numsCopy = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            numsCopy[i] = nums[i];
        }
        Arrays.sort(nums);
        int[] result = new int[2];
        int[] resultIndex = new int[2];
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                result[0] = nums[left];
                result[1] = nums[right];
                left++;
                right--;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        resultIndex[0] = -1;
        resultIndex[1] = -1;
       for(int i = 0; i < numsCopy.length; i++){
           if(resultIndex[0] == -1 && result[0] == numsCopy[i]){
               resultIndex[0] = i;
           }
           if(result[1] == numsCopy[i]){
               resultIndex[1] = i;
           }
       }
       return resultIndex;
    }
}