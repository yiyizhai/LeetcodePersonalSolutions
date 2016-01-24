public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len - 1;
        int cnt = 0;
        int one = 0;
        int ten = 1;
       
       for(int j = len-1; j >=0; j--){
           digits[j] += ten;
           ten = digits[j]/10;
           digits[j] = digits[j] %10;
       }
       if(ten == 1){
           int[] ndi = new int[len+1];
           ndi[0] = ten;
           for(int k = 1; k<len+1; k++){
               ndi[k] = digits[k-1];
           }
           return ndi;
       }
       else
            return digits;
   /*    if(len == 1){
           digits[0] = digits[0] + 1;
           if(digits[0] > 9){
               int ten = digits[0]/10;
               int one = digits[0]%10;
               int[] re = new int[2];
               re[0] = ten;
               re[1] = one;
               return re;
           }
           return digits;
       }
       
        digits[i] = digits[i] + 1;
        if(digits[i] >= 10){
            cnt = 1;
            digits[i] = digits[i] - 10;
        }
        i--;
        
        while(i > 0){
            digits[i] = digits[i] + cnt;
            if(digits[i] < 10)
                cnt = 0;
            else{
                 cnt = 1;
                 digits[i] = digits[i] - 10;
            }
            i--;
        }
        digits[0] = digits[0] + cnt;
         if(digits[0] > 9){
               int ten = digits[0]/10;
               int one = digits[0]%10;
               int[] re = new int[len + 1];
               re[0] = ten;
               re[1] = one;
               for(int j = 2; j<len+1; j++){
                   re[j]= digits[j-1];
               }
               return re;
         }
         else
            return digits;*/
           
    }
}