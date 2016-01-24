public class Solution {
    public int search(int[] A, int target) {
          if(A == null || A.length == 0){
            return -1;
        }
        
        int start = 0, end = A.length - 1;
        int len = A.length;
        boolean rotated = A[start] > A[end];
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] == target){
                return mid;
            }
            
            if(!rotated){
                if(A[mid] < target){
                    start = mid;
                }else{
                    end = mid;
                }
            }else{
                if(A[mid] < target){
                    if(target < A[0]){
                        start = mid;
                    }else if(target > A[len - 1] && A[mid] > A[len - 1]){
                        start = mid;
                    }else if(target > A[len - 1] && A[mid] < A[0]){
                        end = mid;
                    }
                }
                else{
                    if(target < A[0] && A[mid] < A[0]){
                        end = mid;
                    }else if (target < A[0] && A[mid] > A[len - 1]){
                        start = mid;
                    }else if(target > A[len - 1]){
                        end = mid;
                    }
                }
            }
        }
        if(A[start] == target){
            return start;
        }
        if(A[end] == target){
            return end;
        }
        return -1;
    }
}