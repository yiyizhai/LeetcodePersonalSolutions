public class Solution {
    public int removeDuplicates(int[] nums) {
    int cnt = 0;
	        int len = nums.length;
	        if(len == 0 || len == 1)
	            return len;
	        int i = 0;
	        int j = 0;
	        int du = nums[0];
	        int[] temp = new int[len];
	        for(;i<len-1;){
	            if(nums[i]!=nums[i+1]){	                
	                temp[cnt++] = nums[i];
	                i++;
	            }
	            else{
	                du = nums[i];
	                j = i+1;
	                temp[cnt++] = nums[i];
	                while(j<len && nums[j]==du){
	                    j++;
	                }
	                i = j;
	            }
	        }
	        if(nums[len-1]!=nums[len-2])
	        	temp[cnt++]=nums[len-1];
	        for(int k =0; k< len; k++){
	            nums[k] = temp[k];
	        }
	        
	        return cnt;
    }
}